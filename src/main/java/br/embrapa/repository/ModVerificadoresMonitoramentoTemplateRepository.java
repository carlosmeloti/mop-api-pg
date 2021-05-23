package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.consultas.ModVerificadoresMonitoramentoTemplateRepositoryQuery;

public interface ModVerificadoresMonitoramentoTemplateRepository extends JpaRepository<ModVerificadoresMonitoramentoTemplate, Long>, 
ModVerificadoresMonitoramentoTemplateRepositoryQuery{

}
