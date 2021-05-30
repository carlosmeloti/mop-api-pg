package br.embrapa.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
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
import br.embrapa.model.AppMonitoramento;
import br.embrapa.model.AppVerificadoresMonitoramento;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.AppMonitoramentoRepository;
import br.embrapa.repository.AppVerificadoresMonitoramentoRepository;
import br.embrapa.repository.ModVerificadoresMonitoramentoTemplateRepository;
import br.embrapa.repository.filter.AppMonitoramentoFilter;
import br.embrapa.service.AppMonitoramentoService;



@RestController
@RequestMapping("/appmonitoramento")
public class AppMonitoramentoResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppMonitoramentoResource.class);

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AppMonitoramentoRepository appMonitoramentoRepository;
	@Autowired
	private AppMonitoramentoService appMonitoramentoService;
	@Autowired
	private ModVerificadoresMonitoramentoTemplateRepository modVerificadoresMonitoramentoTemplateRepository;
	@Autowired
	private AppVerificadoresMonitoramentoRepository appVerificadoresMonitoramentoRepository;
	
	@Autowired
	private AppVerificadoresMonitoramentoResource appVerificadoresMonitoramentoResource;

	
	@Autowired
	private ApplicationEventPublisher publisher;

	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADAMOSTRAGEM') and #oauth2.hasScope('read')")
	public Page<AppMonitoramento> Pesquisar(AppMonitoramentoFilter appMonitoramentoFilter, Pageable pageable) {
		return appMonitoramentoRepository.filtrar(appMonitoramentoFilter, pageable);
	}
					
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<AppMonitoramento> criar(@RequestBody AppMonitoramento appMonitoramento, HttpServletResponse response) {
		AppMonitoramento appMonitoramentoSalva = appMonitoramentoRepository.save(appMonitoramento);				
		publisher.publishEvent(new RecursoCriadoEvent(this, response, appMonitoramento.getCdMonitoramento()));
		LOGGER.info("Monitoramento salvo com sucesso!");
		insereVerificadoresDoMonitoramento(appMonitoramentoSalva.getCdTemplate().getCdTemplate(),appMonitoramentoSalva.getCdMonitoramento());
		return ResponseEntity.status(HttpStatus.CREATED).body(appMonitoramentoSalva);
	}
	
	private List<ModVerificadoresMonitoramentoTemplate> listarVerificadores(Long cdtemplate){
		Query query = em.createNativeQuery("select * from r17_verificador_template_m  where r17_cdtemplate = ?1", ModVerificadoresMonitoramentoTemplate.class)
				.setParameter(1, cdtemplate);
		List<ModVerificadoresMonitoramentoTemplate> result =  query.getResultList();
		return result;
	}
	

	private void insereVerificadoresDoMonitoramento(Long cdTemplate, Long cdMonitoramento) {
				
		List<ModVerificadoresMonitoramentoTemplate> verificadores = 
				this.listarVerificadores(cdTemplate);
					
		for (ModVerificadoresMonitoramentoTemplate ver : verificadores) {		
			appVerificadoresMonitoramentoResource.inserirVerificadores(ver, cdMonitoramento);
		}
	}
		
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADAMOSTRAGEM') and #oauth2.hasScope('read')")
	public ResponseEntity <AppMonitoramento>buscarPeloCodigo(@PathVariable Long codigo) {
		AppMonitoramento appMonitoramento = appMonitoramentoRepository.findOne(codigo);
		return appMonitoramento != null ? ResponseEntity.ok(appMonitoramento) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long codigo) {
		appMonitoramentoRepository.delete(codigo);
		LOGGER.info("Monitoramento removido com sucesso!");
	}
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<AppMonitoramento> atualizar(@PathVariable Long codigo, @Valid @RequestBody AppMonitoramento appMonitoramento) {
		AppMonitoramento appMonitoramentoSalva = appMonitoramentoService.atualizar(codigo, appMonitoramento);
		LOGGER.info("Monitoramento atualizado com sucesso!");
		return ResponseEntity.ok(appMonitoramentoSalva);
	}
		
	
}
