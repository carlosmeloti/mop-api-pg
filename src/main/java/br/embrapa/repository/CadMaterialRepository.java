package br.embrapa.repository;

import br.embrapa.model.CadTipoDeMetodo;
import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.CadMaterial;
import br.embrapa.repository.consultas.CadMaterialRepositoryQuery;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CadMaterialRepository extends JpaRepository<CadMaterial, Long>, CadMaterialRepositoryQuery{

    @Query(value = "SELECT * from d09_material_m where d09_cdempresa = 1",  nativeQuery = true)
    List<CadMaterial> listarDadosPadrao();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO d09_material_m(d09_cdempresa, d09_nmmaterial) VALUES (:cdempresa, :nmmaterial)",
            nativeQuery = true)
    void inserirDadosPadrao(@Param("cdempresa") Long cdempresa,
                            @Param("nmmaterial") String nmmaterial);
	

}
