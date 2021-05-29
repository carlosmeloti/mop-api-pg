package br.embrapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.ModNivel3;
import br.embrapa.model.ModNivel4;
import br.embrapa.repository.consultas.ModNivel4RepositoryQuery;

public interface ModNivel4Repository extends JpaRepository<ModNivel4, Long>, ModNivel4RepositoryQuery {
	
	@Query(value = "SELECT d13_cdempresa, d13_cdnivel4, d13_nmnivel4, d13_cdnivel1 +    " +
            "(SELECT COUNT(*) FROM d10_nivel1_m WHERE d10_cdempresa = ( select MAX(d24_cdempresa) " +
            " - 1 from d24_empresa)) as d13_cdnivel1,  d13_cdnivel2 + (SELECT COUNT(*) FROM d11_nivel2_m  " +
            "WHERE d11_cdempresa = ( select MAX(d24_cdempresa) - 1 from d24_empresa)) as d13_cdnivel2, " + 
            "d13_cdnivel3 + (SELECT COUNT(*) FROM d12_nivel3_m WHERE d12_cdempresa = " + 
            "( select MAX(d24_cdempresa) - 1 from d24_empresa)) as d13_cdnivel3 " + 
            "FROM d13_nivel4_m WHERE d13_cdempresa = ( select MAX(d24_cdempresa) - 1 from d24_empresa)",  nativeQuery = true)
	List<ModNivel4> listarDadosPadrao();
    
    @Query(value ="select * from d13_nivel4_m where d13_cdempresa =1" ,nativeQuery = true)
    List<ModNivel4> listarNmNivel4Padrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d13_nivel4_m (d13_cdempresa,d13_cdnivel1, d13_cdnivel2, d13_cdnivel3 ,d13_nmnivel4) "
    		+ "VALUES(:cdempresa, :cdnivel1, :cdnivel2, :cdnivel3, :nmnivel4)", nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("cdnivel1") Long cdnivel1,
                            @Param("cdnivel2") Long cdnivel2,
                            @Param("cdnivel3") Long cdnivel3,
                            @Param("nmnivel4") String nmnivel4);

}
