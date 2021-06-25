package br.embrapa.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.embrapa.event.RecursoCriadoEvent;
import br.embrapa.model.AppAvaliacao;
import br.embrapa.model.AppColetaDeDados;
import br.embrapa.repository.AppAvaliacaoRepository;
import br.embrapa.repository.AppColetaDeDadosRepository;
import br.embrapa.repository.filter.AppAvaliacaoFilter;
import br.embrapa.service.AppAvaliacaoService;

@RestController
@RequestMapping("/appavaliacao")
public class AppAvaliacaoResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppAvaliacaoResource.class);

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private AppAvaliacaoRepository appAvaliacaoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private AppAvaliacaoService appAvaliacaoService;
	
	@Autowired
	private AppColetaDeDadosResource appColetaDeDadosResource;
	
	@Autowired
	private AppColetaDeDadosRepository appColetaDeDadosRepository;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADAMOSTRAGEM') and #oauth2.hasScope('read')")
	public Page<AppAvaliacao> Pesquisar(AppAvaliacaoFilter appAvaliacaoFilter, Pageable pageable) {
		return appAvaliacaoRepository.filtrar(appAvaliacaoFilter, pageable);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<AppAvaliacao> criar(@RequestBody AppAvaliacao appAvaliacao, HttpServletResponse response) {
		AppAvaliacao appAvaliacaoSalva = appAvaliacaoRepository.save(appAvaliacao);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, appAvaliacao.getCdAvaliacao()));
		
		insereAvaliacaoDoMonitoramento(appAvaliacao.getCdEmpresa().getCdEmpresa());
		
		LOGGER.info("Avaliação salva com sucesso!");
		return ResponseEntity.status(HttpStatus.CREATED).body(appAvaliacaoSalva);
	}
	
	
	private List<AppColetaDeDados> listar(Long cdempresa){
		Query query = em.createNativeQuery("select * from avaliacao_monitoramento", AppColetaDeDados.class);
		List<AppColetaDeDados> result =  query.getResultList();
		return result;
	}
	
	
	private void insereAvaliacaoDoMonitoramento(Long cdempresa) {
		
		List<AppColetaDeDados> avaliacoes = this.listar(cdempresa);
					
		for (AppColetaDeDados ava : avaliacoes) {	
			try {
				LOGGER.info("Inserindo avaliações do monitoramento!");
				appColetaDeDadosRepository.salvar(ava.getCdEmpresa().getCdEmpresa(), ava.getId_Verificador_m().getCdVerificador(),
												  ava.getCdTipoDeVerificador().getCdTipoDeVerificador(), ava.getCdMonitoramento().getCdMonitoramento(),
												  ava.getCdAvaliacao().getCdAvaliacao());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADAMOSTRAGEM') and #oauth2.hasScope('read')")
	public ResponseEntity <AppAvaliacao>buscarPeloCodigo(@PathVariable Long codigo) {
		AppAvaliacao appAvaliacao = appAvaliacaoRepository.findOne(codigo);
		return appAvaliacao != null ? ResponseEntity.ok(appAvaliacao) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long codigo) {
		appAvaliacaoRepository.delete(codigo);
		LOGGER.info("Avaliação removida com sucesso!");
	}
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<AppAvaliacao> atualizar(@PathVariable Long codigo, @Valid @RequestBody AppAvaliacao appAvaliacao) {
		AppAvaliacao appAvaliacaoSalva = appAvaliacaoService.atualizar(codigo, appAvaliacao);
		LOGGER.info("Avaliação atualizada com sucesso!");
		return ResponseEntity.ok(appAvaliacaoSalva);
			
	}
	
	
}
