package br.embrapa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.Verificador_m;
import br.embrapa.repository.consultas.Verificador_mRepositoryQuery;

public interface Verificador_mRepository extends JpaRepository<Verificador_m, Long>, Verificador_mRepositoryQuery {


    @Query(value = "select * from p01_verificador_m where p01_cdempresa = 1;",  nativeQuery = true)
    List<Verificador_m> listarDadosPadrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO p01_verificador_m(p01_cdempresa, p01_cdverificador, p01_cdtipoverificador," +
            "p01_codalfa, p01_cdnivelavaliacao, p01_nmverificador, p01_limiar, p01_graco) " +
            "VALUES (:cdempresa, :cdverificador, :cdtipoverificador, :codalfa, :cdnivelavaliacao, " +
            ":nmverificador, :limiar, :graco)",
            nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("cdverificador") Long cdverificador,
                            @Param("cdtipoverificador") Long cdtipoverificador,
                            @Param("codalfa") String codalfa, @Param("cdnivelavaliacao") Long cdnivelavaliacao,
                            @Param("nmverificador") String nmverificador, @Param("limiar") String limiar,
                            @Param("graco") BigDecimal graco);
	
	
}
