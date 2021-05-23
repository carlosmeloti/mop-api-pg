package br.embrapa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.embrapa.model.AppVerificadoresMonitoramento;
import br.embrapa.repository.AppVerificadoresMonitoramentoRepository;
import br.embrapa.repository.filter.AppVerificadoresMonitoramentoFilter;

@RestController
@RequestMapping("/appverificadoresmonitoramento")
public class AppVerificadoresMonitoramentoResource {
	
	@Autowired
	private AppVerificadoresMonitoramentoRepository appVerificadoresMonitoramentoRepository;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_VERIFICADOR_M') and #oauth2.hasScope('read')")
	public Page<AppVerificadoresMonitoramento> Pesquisar(AppVerificadoresMonitoramentoFilter appVerificadoresMonitoramentoFilter, Pageable pageable) {
		return appVerificadoresMonitoramentoRepository.filtrar(appVerificadoresMonitoramentoFilter,pageable);
	}

}
