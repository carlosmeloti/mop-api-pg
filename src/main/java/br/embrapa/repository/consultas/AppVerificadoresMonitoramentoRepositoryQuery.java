package br.embrapa.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.embrapa.model.AppVerificadoresMonitoramento;
import br.embrapa.repository.filter.AppVerificadoresMonitoramentoFilter;


public interface AppVerificadoresMonitoramentoRepositoryQuery {

	public Page<AppVerificadoresMonitoramento> filtrar(AppVerificadoresMonitoramentoFilter 
			appVerificadoresMonitoramentoFilter, Pageable pageable);
	
}
