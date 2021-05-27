package br.embrapa.repository;

import br.embrapa.model.ModLocal1;
import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.ModNivel1;
import br.embrapa.repository.consultas.ModNivel1RepositoryQuery;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ModNivel1Repository extends JpaRepository<ModNivel1, Long>, ModNivel1RepositoryQuery{

    @Query(value = "select * from d03_local1_m where d03_cdempresa = 1;",  nativeQuery = true)
    List<ModLocal1> listarDadosPadrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d03_local1_m(d03_cdempresa, d03_nmlocal1) VALUES (:cdempresa, :nmlocal1)",
            nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("nmlocal1") String nmlocal1);
}
