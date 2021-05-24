package br.embrapa.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import br.embrapa.model.Verificador_m;
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
import br.embrapa.repository.CadEmpresaRepository;
import br.embrapa.repository.filter.CadEmpresaFilter;
import br.embrapa.service.CadEmpresaService;

@RestController
@RequestMapping("/cadempresa")
public class CadEmpresaResource {
	
	@Autowired
	private CadEmpresaRepository cadEmpresaRepository;

	@Autowired
	private CadEmpresaService cadEmpresaService;

	@Autowired
	private CadAmostragemResource cadAmostragemResource;

	@Autowired
	private CadFrequenciaResource cadFrequenciaResource;

	@Autowired
	private CadTipoDeMetodoResource cadTipoDeMetodoResource;

	@Autowired
	private CadMaterialResource cadMaterialResource;

	@Autowired
	private Verificador_mResource verificador_mResource;

	@Autowired
	private ModLocal1Resource modLocal1Resource;

	@Autowired
	private ModLocal2Resource modLocal2Resource;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')")
	public Page<CadEmpresa> pesquisar(CadEmpresaFilter cadEmpresaFilter, Pageable pageable){
		return cadEmpresaRepository.filtrar(cadEmpresaFilter, pageable);
	}
	
		
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<CadEmpresa> criar(@RequestBody CadEmpresa cadEmpresa, HttpServletResponse response) {
		CadEmpresa cadEmpresaSalva = cadEmpresaRepository.save(cadEmpresa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cadEmpresaSalva.getCdEmpresa()));

		cadAmostragemResource.populaCadAmostragem(cadEmpresaSalva.getCdEmpresa());
		cadFrequenciaResource.populaCadFrequencia(cadEmpresaSalva.getCdEmpresa());
		cadTipoDeMetodoResource.populaCadTipoDeMetodo(cadEmpresaSalva.getCdEmpresa());
		cadMaterialResource.populaCadTipoDeMetodo(cadEmpresaSalva.getCdEmpresa());
		verificador_mResource.populaVerificador_m(cadEmpresaSalva.getCdEmpresa());
		modLocal1Resource.populaModLocal1(cadEmpresa.getCdEmpresa());
		modLocal2Resource.populaModLocal2(cadEmpresaSalva.getCdEmpresa());

		return ResponseEntity.status(HttpStatus.CREATED).body(cadEmpresaSalva);
	}
	
	@GetMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMPRESA') and #oauth2.hasScope('read')")
	public ResponseEntity <CadEmpresa>buscarPeloCodigo(@PathVariable Long cdEmpresa) {
		CadEmpresa cadEmpresa = cadEmpresaRepository.findOne(cdEmpresa);
		return cadEmpresa != null ? ResponseEntity.ok(cadEmpresa) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_EMPRESA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cdEmpresa) {
		cadEmpresaRepository.delete(cdEmpresa);
	}
	
	@PutMapping("/{cdEmpresa}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMPRESA') and #oauth2.hasScope('write')")
	public ResponseEntity<CadEmpresa> atualizar(@PathVariable Long cdEmpresa, @Valid @RequestBody CadEmpresa cadEmpresa) {
		CadEmpresa cadEmpresaSalva = cadEmpresaService.atualizar(cdEmpresa, cadEmpresa);
		return ResponseEntity.ok(cadEmpresaSalva);
	}
	
	
	
	
	
	
}

