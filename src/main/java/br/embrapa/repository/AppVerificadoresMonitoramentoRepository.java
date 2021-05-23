package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.AppVerificadoresMonitoramento;
import br.embrapa.repository.consultas.AppVerificadoresMonitoramentoRepositoryQuery;

public interface AppVerificadoresMonitoramentoRepository extends 
JpaRepository<AppVerificadoresMonitoramento, Long>, AppVerificadoresMonitoramentoRepositoryQuery {

}
