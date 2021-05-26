package br.embrapa.repository;

import br.embrapa.model.ModLocal2;
import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.ModLocal3;
import br.embrapa.repository.consultas.ModLocal3RepositoryQuery;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ModLocal3Repository extends JpaRepository<ModLocal3, Long>, ModLocal3RepositoryQuery {

    @Query(value = "select d05_nmlocal3, d05_cdempresa, d05_cdlocal1 + " +
            "(select count(*) from d03_local1_m where d03_cdempresa = " +
            "( select MAX(d24_cdempresa) - 1 from d24_empresa)) as d05_cdlocal1, " +
            "d05_cdlocal2 + (select count(*) from d04_local2_m where d04_cdempresa = " +
            "( select MAX(d24_cdempresa) - 1 from d24_empresa)) as d05_cdlocal2, d05_cdlocal3 " +
            "from d05_local3_m where d05_cdempresa =  ( select MAX(d24_cdempresa) - 1 from d24_empresa)",  nativeQuery = true)
    List<ModLocal3> listarDadosPadrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d05_local3_m (d05_cdempresa, d05_cdlocal1, d05_cdlocal2, d05_nmlocal3) " +
            "VALUES (:cdempresa, :cdlocal1, :cdlocal2, :nmlocal3);",
            nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("cdlocal1") Long cdlocal1,
                            @Param("cdlocal2") Long cdlocal2,
                            @Param("nmlocal3") String nmlocal3);
}
