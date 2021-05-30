package br.embrapa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="r17_verificador_monitoramento")
public class AppVerificadoresMonitoramento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="r17_cdverimod")
	private Long cdVeriMod;
	
	@Column(name="r17_cdempresa")
	private Long cdEmpresa;
	
	@Column(name="r17_cdverificador")
	private Long cdVerificador;
	
	@Column(name="r17_cdtipoverificador")
	private Long cdTipoDeVerificador;
	
	@Column(name="r17_cdmonitoramento")
	private Long cdMonitoramento;
	
	@Column(name="r17_cdnivel1")
	private Long cdNivel1;
	
	@Column(name="r17_cdnivel2")
	private Long cdNivel2;
	
	@Column(name="r17_cdnivel3")
	private Long cdNivel3;
	
	@Column(name="r17_cdnivel4")
	private Long cdNivel4;
	
	@Column(name="r17_lgdadosanaliticos")
	private Boolean lgDadosAnaliticos;
	
	@Column(name="r17_lgdadosagrupados")
	private Boolean lgDadosAgrupados;
	
	@Column(name = "r17_txcoletaanalitica")
	private String txColetaAnalitica;
	
	@Column(name = "r17_txcoletaagrupada")
	private String txColetaAgrupada;

	public Long getCdVeriMod() {
		return cdVeriMod;
	}

	public void setCdVeriMod(Long cdVeriMod) {
		this.cdVeriMod = cdVeriMod;
	}

	
	public Long getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(Long cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public Long getCdVerificador() {
		return cdVerificador;
	}

	public void setCdVerificador(Long cdVerificador) {
		this.cdVerificador = cdVerificador;
	}

	public Long getCdTipoDeVerificador() {
		return cdTipoDeVerificador;
	}

	public void setCdTipoDeVerificador(Long cdTipoDeVerificador) {
		this.cdTipoDeVerificador = cdTipoDeVerificador;
	}

	public Long getCdMonitoramento() {
		return cdMonitoramento;
	}

	public void setCdMonitoramento(Long cdMonitoramento) {
		this.cdMonitoramento = cdMonitoramento;
	}

	public Long getCdNivel1() {
		return cdNivel1;
	}

	public void setCdNivel1(Long cdNivel1) {
		this.cdNivel1 = cdNivel1;
	}

	public Long getCdNivel2() {
		return cdNivel2;
	}

	public void setCdNivel2(Long cdNivel2) {
		this.cdNivel2 = cdNivel2;
	}

	public Long getCdNivel3() {
		return cdNivel3;
	}

	public void setCdNivel3(Long cdNivel3) {
		this.cdNivel3 = cdNivel3;
	}

	public Long getCdNivel4() {
		return cdNivel4;
	}

	public void setCdNivel4(Long cdNivel4) {
		this.cdNivel4 = cdNivel4;
	}

	public Boolean getLgDadosAnaliticos() {
		return lgDadosAnaliticos;
	}

	public void setLgDadosAnaliticos(Boolean lgDadosAnaliticos) {
		this.lgDadosAnaliticos = lgDadosAnaliticos;
	}

	public Boolean getLgDadosAgrupados() {
		return lgDadosAgrupados;
	}

	public void setLgDadosAgrupados(Boolean lgDadosAgrupados) {
		this.lgDadosAgrupados = lgDadosAgrupados;
	}

	public String getTxColetaAnalitica() {
		return txColetaAnalitica;
	}

	public void setTxColetaAnalitica(String txColetaAnalitica) {
		this.txColetaAnalitica = txColetaAnalitica;
	}

	public String getTxColetaAgrupada() {
		return txColetaAgrupada;
	}

	public void setTxColetaAgrupada(String txColetaAgrupada) {
		this.txColetaAgrupada = txColetaAgrupada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdVeriMod == null) ? 0 : cdVeriMod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppVerificadoresMonitoramento other = (AppVerificadoresMonitoramento) obj;
		if (cdVeriMod == null) {
			if (other.cdVeriMod != null)
				return false;
		} else if (!cdVeriMod.equals(other.cdVeriMod))
			return false;
		return true;
	}
	
	
	
	

}
