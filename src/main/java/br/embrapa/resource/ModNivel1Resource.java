package br.embrapa.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import br.embrapa.model.CadFrequencia;
import br.embrapa.model.ModNivel1;
import br.embrapa.repository.ModNivel1Repository;
import br.embrapa.repository.filter.ModNivel1Filter;
import br.embrapa.service.ModNivel1Service;



@RestController
@RequestMapping("/modnivel1")
public class ModNivel1Resource {
	
	@Autowired
	private ModNivel1Repository modNivel1Repository;
	
	@Autowired
	private ModNivel1Service modNivel1Service;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<ModNivel1> criar(@RequestBody ModNivel1 ModNivel1, HttpServletResponse response) {
		ModNivel1 ModNivel1Salva = modNivel1Repository.save(ModNivel1);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, ModNivel1Salva.getCdNivel1()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ModNivel1Salva);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL1') and #oauth2.hasScope('read')")
	public Page<ModNivel1> Pesquisar(ModNivel1Filter modNivel1Filter, Pageable pageable) {
		return modNivel1Repository.filtrar(modNivel1Filter, pageable);
	}
	
	
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL2') and #oauth2.hasScope('read')")
	public ResponseEntity <ModNivel1>buscarPeloCodigo(@PathVariable Long codigo) {
		ModNivel1 modNivel1 = modNivel1Repository.findOne(codigo);
		return modNivel1 != null ? ResponseEntity.ok(modNivel1) : ResponseEntity.notFound().build();
		
	}	
		
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		modNivel1Repository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<ModNivel1> atualizar(@PathVariable Long codigo, @Valid @RequestBody ModNivel1 modNivel1) {
		ModNivel1 modNivel1Salva = modNivel1Service.atualizar(codigo, modNivel1);
		return ResponseEntity.ok(modNivel1Salva);
	}
	
	
	public void populaModNivel1(Long cdEmpresa) {
		try {
			List<ModNivel1> resultado = modNivel1Repository.listarDadosPadrao();
			for(ModNivel1 modNivel1: resultado) {
				modNivel1Repository.inserirDadosPadrao(cdEmpresa, modNivel1.getNmNivel1());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}