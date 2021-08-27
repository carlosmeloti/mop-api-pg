package br.embrapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.CadFrequencia;
import br.embrapa.repository.consultas.CadFrequenciaRepositoryQuery;

public interface CadFrequenciaRepository extends JpaRepository<CadFrequencia, Long>, CadFrequenciaRepositoryQuery {

    @Query(value = "select * from d08_frequencia_m where d08_cdempresa = 1",  nativeQuery = true)
    List<CadFrequencia> listarDadosPadrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d08_frequencia_m(d08_cdempresa, d08_nmfrequencia) VALUES (:cdempresa, :nmfrequencia)",
            nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("nmfrequencia") String nmfrequencia);

}
