package br.embrapa.resource;

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

import br.embrapa.dto.AvaliacaoMonitoramentoDTO;
import br.embrapa.event.RecursoCriadoEvent;
import br.embrapa.model.AppColetaDeDados;
import br.embrapa.model.AppVerificadoresMonitoramento;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.AppColetaDeDadosRepository;
import br.embrapa.repository.filter.AppColetaDeDadosFilter;
import br.embrapa.service.AppColetaDeDadosService;

@RestController
@RequestMapping("/appcoletadedados")
public class AppColetaDeDadosResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppColetaDeDadosResource.class);


	@Autowired
	private AppColetaDeDadosRepository appColetaDeDadosRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private AppColetaDeDadosService appColetaDeDadosService;
	
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADAMOSTRAGEM') and #oauth2.hasScope('read')")
	public Page<AppColetaDeDados> Pesquisar(AppColetaDeDadosFilter appColetaDeDadosFilter, Pageable pageable) {
		return appColetaDeDadosRepository.filtrar(appColetaDeDadosFilter, pageable);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<AppColetaDeDados> criar(@RequestBody AppColetaDeDados appColetaDeDados, HttpServletResponse response) {
		AppColetaDeDados appColetaDeDadosSalva = appColetaDeDadosRepository.save(appColetaDeDados);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, appColetaDeDados.getCdColetaDeDaDos()));
		
		LOGGER.info("Coleta de Dados salva com sucesso!");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(appColetaDeDadosSalva);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADAMOSTRAGEM') and #oauth2.hasScope('read')")
	public ResponseEntity <AppColetaDeDados>buscarPeloCodigo(@PathVariable Long codigo) {
		AppColetaDeDados appColetaDeDados = appColetaDeDadosRepository.findOne(codigo);
		return appColetaDeDados != null ? ResponseEntity.ok(appColetaDeDados) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long codigo) {
		appColetaDeDadosRepository.delete(codigo);
		LOGGER.info("Coleta de Dados removida com sucesso!");

	}
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<AppColetaDeDados> atualizar(@PathVariable Long codigo, @Valid @RequestBody AppColetaDeDados appColetaDeDados) {
		AppColetaDeDados appColetaDeDadosSalva = appColetaDeDadosService.atualizar(codigo, appColetaDeDados);
		LOGGER.info("Coleta de Dados atualizada com sucesso!");
		return ResponseEntity.ok(appColetaDeDadosSalva);
	}
	
	
	

}
