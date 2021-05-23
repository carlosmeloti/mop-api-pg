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
import br.embrapa.model.AssociarVerificadorAosLocais;
import br.embrapa.repository.AssociarVerificadorAosLocaisRepository;
import br.embrapa.repository.filter.AssociarVerificadorAosLocaisFilter;
import br.embrapa.service.AssociarVerificadorAosLocaisService;

@RestController
@RequestMapping("/associarverificadores")
public class AssociarVerificadorAosLocaisResource {


	@Autowired
	private AssociarVerificadorAosLocaisRepository associarVerificadorAosLocaisRepository;
	@Autowired
	private AssociarVerificadorAosLocaisService associarVerificadorAosLocaisService;
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADAMOSTRAGEM') and #oauth2.hasScope('read')")
	public Page<AssociarVerificadorAosLocais> Pesquisar(AssociarVerificadorAosLocaisFilter associarVerificadorAosLocaisFilter, Pageable pageable) {
		return associarVerificadorAosLocaisRepository.filtrar(associarVerificadorAosLocaisFilter, pageable);
	}
	
					
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<AssociarVerificadorAosLocais> criar(@RequestBody AssociarVerificadorAosLocais associarVerificadorAosLocais, HttpServletResponse response) {
		AssociarVerificadorAosLocais associarVerificadorAosLocaisSalva = associarVerificadorAosLocaisRepository.save(associarVerificadorAosLocais);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, associarVerificadorAosLocais.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(associarVerificadorAosLocaisSalva);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADAMOSTRAGEM') and #oauth2.hasScope('read')")
	public ResponseEntity <AssociarVerificadorAosLocais>buscarPeloCodigo(@PathVariable Long codigo) {
		AssociarVerificadorAosLocais associarVerificadorAosLocais = associarVerificadorAosLocaisRepository.findOne(codigo);
		return associarVerificadorAosLocais != null ? ResponseEntity.ok(associarVerificadorAosLocais) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long codigo) {
		associarVerificadorAosLocaisRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<AssociarVerificadorAosLocais> atualizar(@PathVariable Long codigo, @Valid @RequestBody AssociarVerificadorAosLocais associarVerificadorAosLocais) {
		AssociarVerificadorAosLocais associarVerificadorAosLocaisSalva = associarVerificadorAosLocaisService.atualizar(codigo, associarVerificadorAosLocais);
		return ResponseEntity.ok(associarVerificadorAosLocaisSalva);
	}
		
	
}
