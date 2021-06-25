package br.embrapa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="r17_verificador_template_m")
public class ModVerificadoresMonitoramentoTemplate {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="r17_cdverimod")
	private Long cdVeriMod;
	
	@ManyToOne
	@JoinColumn(name="r17_cdempresa", referencedColumnName="d24_cdempresa" )
	private CadEmpresa cdEmpresa;
	
	@ManyToOne
	@JoinColumn(name="r17_cdverificador", referencedColumnName="p01_id_Verificador_m")
	private Verificador_m cdVerificador;
	
	@ManyToOne
	@JoinColumn(name="r17_cdtipoverificador")
	private CadTipoDeVerificador cdTipoDeVerificador;
	
	@ManyToOne
	@JoinColumn(name="r17_cdtemplate", referencedColumnName="d14_cdtemplate")
	private ModMonitoramentoTemplate cdTemplate;
	
	@ManyToOne
	@JoinColumn(name="r17_cdnivel1")
	private ModNivel1 cdNivel1;
	
	@ManyToOne
	@JoinColumn(name="r17_cdnivel2")
	private ModNivel2 cdNivel2;
	
	@ManyToOne
	@JoinColumn(name="r17_cdnivel3")
	private ModNivel3 cdNivel3;
	
	@ManyToOne
	@JoinColumn(name="r17_cdnivel4")
	private ModNivel4 cdNivel4;
	
	@Column(name="r17_lgdadosanaliticos")
	private boolean lgDadosAnaliticos;
	
	@Column(name="r17_lgdadosagrupados")
	private boolean lgDadosAgrupados;
	
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

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	
	public Verificador_m getCdVerificador() {
		return cdVerificador;
	}

	public void setCdVerificador(Verificador_m cdVerificador) {
		this.cdVerificador = cdVerificador;
	}

	public CadTipoDeVerificador getCdTipoDeVerificador() {
		return cdTipoDeVerificador;
	}

	public void setCdTipoVerificador(CadTipoDeVerificador cdTipoDeVerificador) {
		this.cdTipoDeVerificador = cdTipoDeVerificador;
	}

	
	public ModMonitoramentoTemplate getCdTemplate() {
		return cdTemplate;
	}

	public void setCdTemplate(ModMonitoramentoTemplate cdTemplate) {
		this.cdTemplate = cdTemplate;
	}

	public ModNivel1 getCdNivel1() {
		return cdNivel1;
	}

	public void setCdNivel1(ModNivel1 cdNivel1) {
		this.cdNivel1 = cdNivel1;
	}

	public ModNivel2 getCdNivel2() {
		return cdNivel2;
	}

	public void setCdNivel2(ModNivel2 cdNivel2) {
		this.cdNivel2 = cdNivel2;
	}

	public ModNivel3 getCdNivel3() {
		return cdNivel3;
	}

	public void setCdNivel3(ModNivel3 cdNivel3) {
		this.cdNivel3 = cdNivel3;
	}

	public ModNivel4 getCdNivel4() {
		return cdNivel4;
	}

	public void setCdNivel4(ModNivel4 cdNivel4) {
		this.cdNivel4 = cdNivel4;
	}

	public boolean getLgDadosAnaliticos() {
		return lgDadosAnaliticos;
	}

	public void setLgDadosAnaliticos(boolean lgDadosAnaliticos) {
		this.lgDadosAnaliticos = lgDadosAnaliticos;
	}

	public boolean getLgDadosAgrupados() {
		return lgDadosAgrupados;
	}

	public void setLgDadosAgrupados(boolean lgDadosAgrupados) {
		if(lgDadosAgrupados == true || lgDadosAgrupados == false) {
			this.lgDadosAgrupados = lgDadosAgrupados;
		} else {
			this.lgDadosAgrupados = false;
		}
		
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
		ModVerificadoresMonitoramentoTemplate other = (ModVerificadoresMonitoramentoTemplate) obj;
		if (cdVeriMod == null) {
			if (other.cdVeriMod != null)
				return false;
		} else if (!cdVeriMod.equals(other.cdVeriMod))
			return false;
		return true;
	}

	
	

}
