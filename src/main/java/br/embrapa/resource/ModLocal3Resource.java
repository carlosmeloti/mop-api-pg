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
import br.embrapa.model.ModLocal3;
import br.embrapa.repository.ModLocal3Repository;
import br.embrapa.repository.filter.ModLocal3Filter;
import br.embrapa.repository.projections.ResumoModLocal3;
import br.embrapa.service.ModLocal3Service;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/sublocaldeavaliacao")
public class ModLocal3Resource {
	
	@Autowired
	private ModLocal3Repository modLocal3Repository;

	public ModLocal3Resource() {
	}


	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL3') and #oauth2.hasScope('read')")
	public Page<ModLocal3> Pesquisar(ModLocal3Filter modLocal3Filter, Pageable pageable) {
		return modLocal3Repository.filtrar(modLocal3Filter, pageable);
	}
	
	@GetMapping(params = "resumo")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL2') and #oauth2.hasScope('read')")
	public Page<ResumoModLocal3> resumir(ModLocal3Filter modLocal3Filter, Pageable pageable) {
		return modLocal3Repository.resumir(modLocal3Filter, pageable);
	}
	

	
	@Autowired
	private ModLocal3Service modLocal3Service;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<ModLocal3> criar(@RequestBody ModLocal3 modLocal3, HttpServletResponse response) {
		ModLocal3 modLocal3Salva = modLocal3Repository.save(modLocal3);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, modLocal3Salva.getCdLocal3()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(modLocal3Salva);
	}
	
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL2') and #oauth2.hasScope('read')")
	public ResponseEntity <ModLocal3>buscarPeloCodigo(@PathVariable Long codigo) {
		ModLocal3 modLocal3 = modLocal3Repository.findOne(codigo);
		return modLocal3 != null ? ResponseEntity.ok(modLocal3) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CADLOCAL3') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		modLocal3Repository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<ModLocal3> atualizar(@PathVariable Long codigo, @Valid @RequestBody ModLocal3 modLocal3) {
		ModLocal3 modLocal3Salva = modLocal3Service.atualizar(codigo, modLocal3);
		return ResponseEntity.ok(modLocal3Salva);
	}

	public void populaModLocal3(Long cdEmpresa) {
		try {
			List<ModLocal3> resultadoCd = modLocal3Repository.listarDadosPadrao();
			List<ModLocal3> resultadoNomeLocal3 = modLocal3Repository.listarNmLocal3Padrao();
			
			for(int i = 0 ; i < resultadoNomeLocal3.size(); i++) {

				modLocal3Repository.inserirDadosPadrao(cdEmpresa, 
						resultadoCd.get(i).getCdLocal1().getCdLocal1(), resultadoCd.get(i).getCdLocal2().getCdLocal2(),
						resultadoNomeLocal3.get(i).getNmLocal3());	
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
