package br.embrapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.ModNivel2;
import br.embrapa.model.ModNivel3;
import br.embrapa.repository.consultas.ModNivel3RepositoryQuery;


public interface ModNivel3Repository extends JpaRepository<ModNivel3, Long>, ModNivel3RepositoryQuery{

	
	
	
	@Query(value = "SELECT d12_cdempresa, d12_cdnivel3, d12_nmnivel3, d12_cdnivel1 +   " +
            "(SELECT COUNT(*) FROM d10_nivel1_m WHERE d10_cdempresa = ( select MAX(d24_cdempresa)" +
            " - 1 from d24_empresa)) as d12_cdnivel1,  d12_cdnivel2 + (SELECT COUNT(*) FROM d11_nivel2_m " +
            "WHERE d11_cdempresa = ( select MAX(d24_cdempresa) - 1 from d24_empresa)) as d12_cdnivel2 " + 
            "FROM d12_nivel3_m WHERE d12_cdempresa = ( select MAX(d24_cdempresa) - 1 from d24_empresa)",  nativeQuery = true)
	List<ModNivel3> listarDadosPadrao();
    
    @Query(value ="select * from d12_nivel3_m where d12_cdempresa =1" ,nativeQuery = true)
    List<ModNivel3> listarNmNivel3Padrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d12_nivel3_m (d12_cdempresa,d12_cdnivel1, d12_cdnivel2,d12_nmnivel3) "
    		+ "VALUES(:cdempresa, :cdnivel1, :cdnivel2 , :nmnivel3)", nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("cdnivel1") Long cdnivel1,
                            @Param("cdnivel2") Long cdnivel2,
                            @Param("nmnivel3") String nmnivel3);
	
}
