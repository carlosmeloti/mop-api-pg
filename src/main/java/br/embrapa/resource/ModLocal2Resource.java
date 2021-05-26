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
import br.embrapa.model.ModLocal2;
import br.embrapa.repository.ModLocal2Repository;
import br.embrapa.repository.filter.ModLocal2Filter;
import br.embrapa.repository.projections.ResumoModLocal2;
import br.embrapa.service.ModLocal2Service;

import java.util.List;


@RestController
@RequestMapping("/localdeavaliacao")
public class ModLocal2Resource {
	
	@Autowired
	private ModLocal2Repository modLocal2Repository;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL2') and #oauth2.hasScope('read')")
	public Page<ModLocal2> Pesquisar(ModLocal2Filter modLocal2Filter, Pageable pageable) {
		return modLocal2Repository.filtrar(modLocal2Filter, pageable);
	}
	
	@GetMapping(params = "resumo")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL2') and #oauth2.hasScope('read')")
	public Page<ResumoModLocal2> resumir(ModLocal2Filter modLocal2Filter, Pageable pageable) {
		return modLocal2Repository.resumir(modLocal2Filter, pageable);
	}
	
	@Autowired
	private ModLocal2Service modLocal2Service;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<ModLocal2> criar(@RequestBody ModLocal2 modLocal2, HttpServletResponse response) {
		ModLocal2 modLocal2Salva = modLocal2Repository.save(modLocal2);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, modLocal2Salva.getCdLocal2()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(modLocal2Salva);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL2') and #oauth2.hasScope('read')")
	public ResponseEntity <ModLocal2>buscarPeloCodigo(@PathVariable Long codigo) {
		ModLocal2 modLocal2 = modLocal2Repository.findOne(codigo);
		return modLocal2 != null ? ResponseEntity.ok(modLocal2) : ResponseEntity.notFound().build();
		
	}

	@DeleteMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CADLOCAL2') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		modLocal2Repository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ModLocal2> atualizar(@PathVariable Long codigo, @Valid @RequestBody ModLocal2 modLocal2) {
		ModLocal2 modLocal2Salva = modLocal2Service.atualizar(codigo, modLocal2);
		return ResponseEntity.ok(modLocal2Salva);
	}

	public void populaModLocal2(Long cdEmpresa) {
		try {
			List<ModLocal2> resultado = modLocal2Repository.listarDadosPadrao();
			for (ModLocal2 modLocal2 : resultado) {
				modLocal2Repository.inserirDadosPadrao(cdEmpresa, modLocal2.getCdLocal1().getCdLocal1(), modLocal2.getNmLocal2());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
