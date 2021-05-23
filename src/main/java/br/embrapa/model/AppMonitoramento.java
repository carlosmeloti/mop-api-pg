package br.embrapa.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 

@Entity
@Table(name="d18_monitoramento")
public class AppMonitoramento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="d18_cdmonitoramento")
	private Long cdMonitoramento;
	 
	@ManyToOne
	@JoinColumn(name="d18_cdtemplate", referencedColumnName = "d14_cdtemplate")
	private ModMonitoramentoTemplate cdTemplate;
	
	@ManyToOne
	@JoinColumn(name="d18_cdempresa", referencedColumnName="d24_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@Column(name="d18_nmmonitoramento")
	private String nmMonitoramento;
		
	@ManyToOne
	@JoinColumn(name="d18_cdtipoverificador")
	private CadTipoDeVerificador cdTipoDeVerificador;
	
	@Column(name="d18_dtcriacao")
	private Date dtCriacao;
	
	@Column(name="d18_txlocal")
	private String txLocal;

	public Long getCdMonitoramento() {
		return cdMonitoramento;
	}

	public void setCdMonitoramento(Long cdMonitoramento) {
		this.cdMonitoramento = cdMonitoramento;
	}

	public ModMonitoramentoTemplate getCdTemplate() {
		return cdTemplate;
	}

	public void setCdTemplate(ModMonitoramentoTemplate cdTemplate) {
		this.cdTemplate = cdTemplate;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getNmMonitoramento() {
		return nmMonitoramento;
	}

	public void setNmMonitoramento(String nmMonitoramento) {
		this.nmMonitoramento = nmMonitoramento;
	}

	public CadTipoDeVerificador getCdTipoDeVerificador() {
		return cdTipoDeVerificador;
	}

	public void setCdTipoDeVerificador(CadTipoDeVerificador cdTipoDeVerificador) {
		this.cdTipoDeVerificador = cdTipoDeVerificador;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String getTxLocal() {
		return txLocal;
	}

	public void setTxLocal(String txLocal) {
		this.txLocal = txLocal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdMonitoramento == null) ? 0 : cdMonitoramento.hashCode());
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
		AppMonitoramento other = (AppMonitoramento) obj;
		if (cdMonitoramento == null) {
			if (other.cdMonitoramento != null)
				return false;
		} else if (!cdMonitoramento.equals(other.cdMonitoramento))
			return false;
		return true;
	}
	
	
	
	
}
