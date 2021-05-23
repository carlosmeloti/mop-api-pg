package br.embrapa.resource;

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
import br.embrapa.model.CadEmpresa;
import br.embrapa.model.ModNivel4;
import br.embrapa.repository.ModNivel4Repository;
import br.embrapa.repository.filter.ModNivel4Filter;
import br.embrapa.service.ModNivel4Service;

@RestController
@RequestMapping("/modnivel4")
public class ModNivel4Resource {

	@Autowired 
	private ModNivel4Repository modNivel4Repository;
	
	@Autowired
	private ModNivel4Service modNivel4Service;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<ModNivel4> criar(@RequestBody ModNivel4 ModNivel4, HttpServletResponse response) {
		ModNivel4 ModNivel4Salva = modNivel4Repository.save(ModNivel4);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, ModNivel4Salva.getCdNivel4()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ModNivel4Salva);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL1') and #oauth2.hasScope('read')")
	public Page<ModNivel4> Pesquisar(ModNivel4Filter modNivel4Filter, Pageable pageable) {
		return modNivel4Repository.filtrar(modNivel4Filter, pageable);
	}
	
	
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL2') and #oauth2.hasScope('read')")
	public ResponseEntity <ModNivel4>buscarPeloCodigo(@PathVariable Long codigo) {
		ModNivel4 modNivel4 = modNivel4Repository.findOne(codigo);
		return modNivel4 != null ? ResponseEntity.ok(modNivel4) : ResponseEntity.notFound().build();
		
	}	
			
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		modNivel4Repository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<ModNivel4> atualizar(@PathVariable Long codigo, @Valid @RequestBody ModNivel4 modNivel4) {
		ModNivel4 modNivel4Salva = modNivel4Service.atualizar(codigo, modNivel4);
		return ResponseEntity.ok(modNivel4Salva);
	}
	
}
