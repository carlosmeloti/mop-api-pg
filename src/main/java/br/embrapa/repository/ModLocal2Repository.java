package br.embrapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.ModLocal2;
import br.embrapa.repository.consultas.ModLocal2RepositoryQuery;

public interface ModLocal2Repository extends JpaRepository<ModLocal2, Long>, ModLocal2RepositoryQuery {

    @Query(value = "select d04_cdlocal2, d04_cdempresa,d04_nmlocal2 ,d04_cdlocal1 + " +
            "(select count(*) from d03_local1_m where d03_cdempresa = ( select MAX(d24_cdempresa)" +
            " from d24_empresa) - 1 )  as d04_cdlocal1 from d04_local2_m where d04_cdempresa = " +
            "(select MAX(d24_cdempresa) - 1 from d24_empresa)",  nativeQuery = true)
    List<ModLocal2> listarDadosPadrao();
    
    @Query(value ="select * from d04_local2_m where d04_cdempresa =1" ,nativeQuery = true)
    List<ModLocal2> listarNmLocal2Padrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d04_local2_m (d04_cdempresa, d04_cdlocal1, d04_nmlocal2) " +
            "VALUES (:cdempresa, :cdlocal1, :nmlocal2);",
            nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("cdlocal1") Long cdlocal1,
                            @Param("nmlocal2") String nmlocal2);


}
