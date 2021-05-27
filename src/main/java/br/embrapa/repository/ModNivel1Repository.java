package br.embrapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.ModNivel1;
import br.embrapa.repository.consultas.ModNivel1RepositoryQuery;

public interface ModNivel1Repository extends JpaRepository<ModNivel1, Long>, ModNivel1RepositoryQuery{

    @Query(value = "select * from d10_nivel1_m where d10_cdempresa  = 1",  nativeQuery = true)
    List<ModNivel1> listarDadosPadrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d10_nivel1_m(d10_cdempresa, d10_nmnivel1) VALUES (:cdempresa, :nmnivel1)",
            nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("nmnivel1") String nmnivel1);
}
