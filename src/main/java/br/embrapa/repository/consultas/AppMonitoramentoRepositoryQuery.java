package br.embrapa.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.embrapa.model.AppMonitoramento;
import br.embrapa.repository.filter.AppMonitoramentoFilter;

public interface AppMonitoramentoRepositoryQuery {
             
	public Page<AppMonitoramento> filtrar(AppMonitoramentoFilter appMonitoramentoFilter, Pageable pageable);
	//public Page<ResumoAppMonitoramento> resumir(AppMonitoramentoFilter appMonitoramentoFilter, Pageable pageable);

}
