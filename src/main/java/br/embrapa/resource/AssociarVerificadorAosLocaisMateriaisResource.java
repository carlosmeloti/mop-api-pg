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
import br.embrapa.model.AssociarVerificadorAosLocaisMateriais;
import br.embrapa.repository.AssociarVerificadorAosLocaisMateriaisRepository;
import br.embrapa.repository.filter.AssociarVerificadorAosLocaisMateriaisFilter;
import br.embrapa.service.AssociarVerificadorAosLocaisMateriaisService;

@RestController
@RequestMapping("/associarverificadoresmateriais")
public class AssociarVerificadorAosLocaisMateriaisResource {
	
	@Autowired
	private AssociarVerificadorAosLocaisMateriaisRepository associarVerificadorAosLocaisMateriaisRepository;
	@Autowired
	private AssociarVerificadorAosLocaisMateriaisService associarVerificadorAosLocaisMateriaisService;
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADAMOSTRAGEM') and #oauth2.hasScope('read')")
	public Page<AssociarVerificadorAosLocaisMateriais> Pesquisar(AssociarVerificadorAosLocaisMateriaisFilter associarVerificadorAosLocaisMateriaisFilter, Pageable pageable) {
		return associarVerificadorAosLocaisMateriaisRepository.filtrar(associarVerificadorAosLocaisMateriaisFilter, pageable);
	}
	
					
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<AssociarVerificadorAosLocaisMateriais> criar(@RequestBody AssociarVerificadorAosLocaisMateriais associarVerificadorAosLocaisMateriais, HttpServletResponse response) {
		AssociarVerificadorAosLocaisMateriais associarVerificadorAosLocaisMateriaisSalva = associarVerificadorAosLocaisMateriaisRepository.save(associarVerificadorAosLocaisMateriais);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, associarVerificadorAosLocaisMateriais.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(associarVerificadorAosLocaisMateriaisSalva);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CADAMOSTRAGEM') and #oauth2.hasScope('read')")
	public ResponseEntity <AssociarVerificadorAosLocaisMateriais>buscarPeloCodigo(@PathVariable Long codigo) {
		AssociarVerificadorAosLocaisMateriais associarVerificadorAosLocaisMateriais = associarVerificadorAosLocaisMateriaisRepository.findOne(codigo);
		return associarVerificadorAosLocaisMateriais != null ? ResponseEntity.ok(associarVerificadorAosLocaisMateriais) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long codigo) {
		associarVerificadorAosLocaisMateriaisRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CADAMOSTRAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<AssociarVerificadorAosLocaisMateriais> atualizar(@PathVariable Long codigo, @Valid @RequestBody AssociarVerificadorAosLocaisMateriais associarVerificadorAosLocaisMateriais) {
		AssociarVerificadorAosLocaisMateriais associarVerificadorAosLocaisMateriaisSalva = associarVerificadorAosLocaisMateriaisService.atualizar(codigo, associarVerificadorAosLocaisMateriais);
		return ResponseEntity.ok(associarVerificadorAosLocaisMateriaisSalva);
	}

}
