package br.embrapa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.embrapa.model.AppVerificadoresMonitoramento;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
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


	public void inserirVerificadores(ModVerificadoresMonitoramentoTemplate ver, Long cdMonitoramento) {
		AppVerificadoresMonitoramento appVeriMon = new AppVerificadoresMonitoramento();
		
		/*appVeriMon.setCdEmpresa(ver.getCdEmpresa().getCdEmpresa());
		appVeriMon.setCdVerificador(ver.getCdVerificador().getCdVerificador());
		appVeriMon.setCdTipoDeVerificador(ver.getCdTipoDeVerificador().getCdTipoDeVerificador());
		appVeriMon.setCdMonitoramento(cdMonitoramento);
		appVeriMon.setCdNivel1(ver.getCdNivel1().getCdNivel1());
		appVeriMon.setCdNivel2(ver.getCdNivel2().getCdNivel2());
		appVeriMon.setCdNivel3(ver.getCdNivel3().getCdNivel3());
		appVeriMon.setCdNivel4(ver.getCdNivel4().getCdNivel4());
		appVeriMon.setLgDadosAnaliticos(ver.getLgDadosAnaliticos());
		appVeriMon.setLgDadosAgrupados(ver.getLgDadosAgrupados());
		appVeriMon.setTxColetaAnalitica(ver.getTxColetaAnalitica());
		appVeriMon.setTxColetaAgrupada(ver.getTxColetaAgrupada());*/
		
		appVerificadoresMonitoramentoRepository.inserirVerificadoresMonitoramento(ver.getCdEmpresa().getCdEmpresa(),
				ver.getCdVerificador().getCdVerificador(),ver.getCdTipoDeVerificador().getCdTipoDeVerificador(),
				cdMonitoramento, ver.getCdNivel1().getCdNivel1(),ver.getCdNivel2().getCdNivel2(), ver.getCdNivel3().getCdNivel3(),
				ver.getCdNivel4().getCdNivel4(),ver.getLgDadosAnaliticos(),  ver.getLgDadosAgrupados(), ver.getTxColetaAnalitica(),
				ver.getTxColetaAgrupada());
	}
	
	
	

}
