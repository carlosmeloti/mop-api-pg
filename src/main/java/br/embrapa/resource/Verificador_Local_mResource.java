package br.embrapa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.embrapa.model.Verificador_Local_m;
import br.embrapa.model.Verificador_m;
import br.embrapa.repository.Verificador_Local_mRepository;
import br.embrapa.repository.filter.Verificador_Local_mFilter;
import br.embrapa.service.Verificador_Local_mService;



@RestController
@RequestMapping("/verificador_local_m")
public class Verificador_Local_mResource {
	
	
	@Autowired
	private Verificador_Local_mRepository verificador_Local_mRepository;
	
	@Autowired
	private Verificador_Local_mService verificador_Local_mService; 
	
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_VERIFICADOR_M') and #oauth2.hasScope('read')")
	public List<Verificador_Local_m> Pesquisar(Verificador_Local_mFilter verificador_Local_mFilter) {
		return verificador_Local_mRepository.filtrar(verificador_Local_mFilter);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_VERIFICADOR_M') and #oauth2.hasScope('read')")
	public ResponseEntity <Verificador_Local_m>buscarPeloCodigo(@PathVariable Long codigo) {
		Verificador_Local_m verificador_Local_m = verificador_Local_mRepository.findOne(codigo);
		return verificador_Local_m != null ? ResponseEntity.ok(verificador_Local_m) : ResponseEntity.notFound().build();
		
	}

}
