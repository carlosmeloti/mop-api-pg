package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.embrapa.model.AppVerificadoresMonitoramento;
import br.embrapa.repository.consultas.AppVerificadoresMonitoramentoRepositoryQuery;

public interface AppVerificadoresMonitoramentoRepository extends 
JpaRepository<AppVerificadoresMonitoramento, Long>, AppVerificadoresMonitoramentoRepositoryQuery {

	@Transactional
    @Modifying
    @Query(value ="INSERT into r17_verificador_monitoramento(r17_cdempresa, "
    		+ "r17_cdverificador, r17_cdtipoverificador, r17_cdmonitoramento, "
    		+ "r17_cdnivel1, r17_cdnivel2, r17_cdnivel3, r17_cdnivel4, r17_lgdadosanaliticos, "
    		+ "r17_lgdadosagrupados, r17_txcoletaanalitica, r17_txcoletaagrupada) "
    		+ "VALUES (:cdempresa, :cdverificador, :cdtipoverificador, :cdmonitoramento, "
    		+ ":cdnivel1, :cdnivel2, :cdnivel3, :cdnivel4, :lgdadosanaliticos, "
    		+ ":lgdadosagrupados, :txcoletaanalitica, :txcoletaagrupada)",
            nativeQuery = true)
    void inserirVerificadoresMonitoramento(@Param("cdempresa") Long cdempresa,
                            @Param("cdverificador") Long cdverificador,
                            @Param("cdtipoverificador") Long cdtipoverificador,
                            @Param("cdmonitoramento") Long cdmonitoramento,
                            @Param("cdnivel1") Long cdnivel1,
                            @Param("cdnivel2") Long cdnivel2,
                            @Param("cdnivel3") Long cdnivel3,
                            @Param("cdnivel4") Long cdnivel4,
                            @Param("lgdadosanaliticos") Boolean lgdadosanaliticos,
                            @Param("lgdadosagrupados") Boolean lgdadosagrupados,
                            @Param("txcoletaanalitica") String txcoletaanalitica,
                            @Param("txcoletaagrupada") String txcoletaagrupada);

	//void salvarVerificadoresDoMonitoramento(AppVerificadoresMonitoramento appVeriMon);
	
	
}
