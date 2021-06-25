package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.AppColetaDeDados;
import br.embrapa.repository.consultas.AppColetaDeDadosRepositoryQuery;

public interface AppColetaDeDadosRepository extends JpaRepository<AppColetaDeDados, Long>, AppColetaDeDadosRepositoryQuery {
	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO p21_coleta(p21_cdempresa, p21_id_verificador_m, p21_cdtipoverificador,"
			+ "p21_cdmonitoramento, p21_cdavaliacao)"
			+ "VALUES (:cdempresa, :cdverimod, :cdtipoverificador, :cdmonitoramento, :cdavaliacao)",
			   nativeQuery = true)
	void salvar(@Param("cdempresa") Long cdempresa,
							@Param("cdverimod") Long nmamostragem,
							@Param("cdtipoverificador") Long cdtipoverificador,
							@Param("cdmonitoramento") Long cdmonitoramento,
							@Param("cdavaliacao") Long cdavaliacao);

	
	
	
}
