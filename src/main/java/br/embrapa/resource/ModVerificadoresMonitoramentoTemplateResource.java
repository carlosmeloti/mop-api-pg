package br.embrapa.resource;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.embrapa.event.RecursoCriadoEvent;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.ModVerificadoresMonitoramentoTemplateRepository;
import br.embrapa.repository.consultas.ModVerificadoresMonitoramentoTemplateRepositoryImpl;
import br.embrapa.repository.filter.ModVerificadoresMonitoramentoTemplateFilter;
import br.embrapa.repository.projections.ResumoVerificadoresMonitoramentoTemplate;
import br.embrapa.service.ModVerificadoresMonitoramentoTemplateService;


@RestController
@RequestMapping("/modverificadoresmonitoramentotemplate")
public class ModVerificadoresMonitoramentoTemplateResource {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ModVerificadoresMonitoramentoTemplateRepository modVerificadoresMonitoramentoTemplateRepository;
	
	@Autowired
	private ModVerificadoresMonitoramentoTemplateService modVerificadoresMonitoramentoTemplateService;
	
	@Autowired
	private ModVerificadoresMonitoramentoTemplateRepositoryImpl d;
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_VERIFICADOR_M') and #oauth2.hasScope('read')")
	public Page<ModVerificadoresMonitoramentoTemplate> Pesquisar(ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter, Pageable pageable) {
		return modVerificadoresMonitoramentoTemplateRepository.filtrar(modVerificadoresMonitoramentoTemplateFilter,pageable);
	}
	
	@GetMapping(params = "resumo")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADFREQUENCIA') and #oauth2.hasScope('read')")
	public Page<ResumoVerificadoresMonitoramentoTemplate> resumir(ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter,
			Pageable pageable) {
		return modVerificadoresMonitoramentoTemplateRepository.resumir(modVerificadoresMonitoramentoTemplateFilter, pageable );
	}
	
	@GetMapping("/relatorio")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADFREQUENCIA') and #oauth2.hasScope('read')")
	public ResponseEntity<byte[]> todosVerificadores(@RequestParam Long cdTemplate, @RequestParam boolean ordCatAva, 
			@RequestParam boolean ordHierarquica) throws Exception {
		byte[] relatorio = modVerificadoresMonitoramentoTemplateService.todosVerificadores(cdTemplate, ordCatAva, ordHierarquica);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/count")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_VERIFICADOR_M') and #oauth2.hasScope('read')")
	public BigInteger count(Long cdTemplate) {
		Query query = em.createNativeQuery("select count(*) from r17_verificador_template_m  WHERE r17_cdtemplate =:cdTemplate");
		query.setParameter("cdTemplate", cdTemplate);
		BigInteger result = (BigInteger) query.getSingleResult();
		return result;
	}
	
			
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_VERIFICADOR_M') and #oauth2.hasScope('read')")
	public ResponseEntity <ModVerificadoresMonitoramentoTemplate>buscarPeloCodigo(@PathVariable Long codigo) {
		ModVerificadoresMonitoramentoTemplate modVerificadoresMonitoramentoTemplate = modVerificadoresMonitoramentoTemplateRepository.findOne(codigo);
		return modVerificadoresMonitoramentoTemplate != null ? ResponseEntity.ok(modVerificadoresMonitoramentoTemplate) : ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	public ResponseEntity<ModVerificadoresMonitoramentoTemplate> criar(@RequestBody ModVerificadoresMonitoramentoTemplate modVerificadoresMonitoramentoTemplate, HttpServletResponse response) {
		ModVerificadoresMonitoramentoTemplate modVerificadoresMonitoramentoTemplateSalva = modVerificadoresMonitoramentoTemplateRepository.save(modVerificadoresMonitoramentoTemplate);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, modVerificadoresMonitoramentoTemplateSalva.getCdVeriMod()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(modVerificadoresMonitoramentoTemplateSalva);
	}
	
	@DeleteMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CADFREQUENCIA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		modVerificadoresMonitoramentoTemplateRepository.delete(codigo);
	}


}
