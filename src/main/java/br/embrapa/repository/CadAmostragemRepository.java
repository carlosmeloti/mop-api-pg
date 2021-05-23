package br.embrapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.CadAmostragem;
import br.embrapa.repository.consultas.CadAmostragemRepositoryQuery;

public interface CadAmostragemRepository extends JpaRepository<CadAmostragem, Long>, CadAmostragemRepositoryQuery {

	
		@Query(value = "select * from d06_amostragem_m  where d06_cdempresa  = 1",  nativeQuery = true)
		List<CadAmostragem> listarDadosPadrao();
		
		@Transactional
		@Modifying
		@Query(value ="INSERT INTO d06_amostragem_m(d06_cdempresa, d06_nmamostragem) VALUES (:cdempresa, :nmamostragem)",
				   nativeQuery = true)
		void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
				@Param("nmamostragem") String nmamostragem);
	
	
}
