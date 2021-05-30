package br.embrapa.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.consultas.ModVerificadoresMonitoramentoTemplateRepositoryQuery;

public interface ModVerificadoresMonitoramentoTemplateRepository extends JpaRepository<ModVerificadoresMonitoramentoTemplate, Long>, 
	ModVerificadoresMonitoramentoTemplateRepositoryQuery{
	
		
	@Query(value = "select * from r17_verificador_template_m  where r17_cdtemplate = ?1",  nativeQuery = true)
    List<ModVerificadoresMonitoramentoTemplate> listarVerificadores(Long r17_cdtemplate); 

	
}
