package br.embrapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.ModNivel2;
import br.embrapa.repository.consultas.ModNivel2RepositoryQuery;

public interface ModNivel2Repository extends JpaRepository<ModNivel2, Long>, ModNivel2RepositoryQuery {

	@Query(value = "SELECT d11_cdempresa, d11_cdnivel2, d11_nmnivel2 , d11_cdnivel1 +  " +
            "(SELECT COUNT(*) FROM d10_nivel1_m WHERE d10_cdempresa = (SELECT MAX(d24_cdempresa)" +
            " FROM d24_empresa) - 1) as d11_cdnivel1 FROM d11_nivel2_m WHERE d11_cdempresa =  " +
            "(SELECT MAX(d24_cdempresa) FROM d24_empresa) - 1;",  nativeQuery = true)
    List<ModNivel2> listarDadosPadrao();
    
    @Query(value ="select * from d11_nivel2_m where d11_cdempresa =1" ,nativeQuery = true)
    List<ModNivel2> listarNmLocal2Padrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d11_nivel2_m (d11_cdempresa,d11_cdnivel1, d11_nmnivel2) "
    		+ "VALUES(:cdempresa, :cdnivel1, :nmnivel2)", nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("cdnivel1") Long cdlocal1,
                            @Param("nmnivel2") String nmlocal2);
	
}
