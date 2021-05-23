package br.embrapa.repository;

import br.embrapa.model.CadFrequencia;
import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.CadTipoDeMetodo;
import br.embrapa.repository.consultas.CadTipoDeMetodoRepositoryQuery;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CadTipoDeMetodoRepository extends JpaRepository<CadTipoDeMetodo, Long>, CadTipoDeMetodoRepositoryQuery {

    @Query(value = "select * from d07_tipo_metodo_m where d07_cdempresa = 1",  nativeQuery = true)
    List<CadTipoDeMetodo> listarDadosPadrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d07_tipo_metodo_m(d07_cdempresa, d07_nmtipometodo) VALUES (:cdempresa, :nmtipometodo)",
            nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("nmtipometodo") String nmtipometodo);

}
