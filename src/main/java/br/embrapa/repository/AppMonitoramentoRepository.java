package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.AppMonitoramento;
import br.embrapa.repository.consultas.AppMonitoramentoRepositoryQuery;

public interface AppMonitoramentoRepository extends JpaRepository<AppMonitoramento, Long>, AppMonitoramentoRepositoryQuery {
	
	
	
}
