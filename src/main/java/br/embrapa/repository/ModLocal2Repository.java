package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.ModLocal2;
import br.embrapa.repository.consultas.ModLocal2RepositoryQuery;

public interface ModLocal2Repository extends JpaRepository<ModLocal2, Long>, ModLocal2RepositoryQuery {


	
	//List<ModLocal2> buscarPeloCodigo(@Param("cdEmpresa", "cdLocal1", "cdLocal2") Long cdEmpresa, Long cdLocal1, Long cdLocal2;
	
}
