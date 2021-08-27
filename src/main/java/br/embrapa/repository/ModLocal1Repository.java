package br.embrapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.ModLocal1;
import br.embrapa.repository.consultas.ModLocal1RepositoryQuery;

public interface ModLocal1Repository extends JpaRepository<ModLocal1, Long>, ModLocal1RepositoryQuery{

    @Query(value = "select * from d03_local1_m where d03_cdempresa = 1;",  nativeQuery = true)
    List<ModLocal1> listarDadosPadrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d03_local1_m(d03_cdempresa, d03_nmlocal1) VALUES (:cdempresa, :nmlocal1)",
            nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("nmlocal1") String nmlocal1);
}
