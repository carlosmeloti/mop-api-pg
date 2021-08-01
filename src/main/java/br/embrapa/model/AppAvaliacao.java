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
@Table(name="d19_avaliacao")
public class AppAvaliacao{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="d19_cdavaliacao")
	private Long cdAvaliacao;
	
	@ManyToOne
	@JoinColumn(name="d19_cdempresa", referencedColumnName="d24_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@ManyToOne
	@JoinColumn(name="d19_cdmonitoramento", referencedColumnName="d18_cdmonitoramento")
	private AppMonitoramento cdMonitoramento;
			
	@Column(name="d19_nmavaliacao") 
	private String nmAvaliacao;
	
	@Column(name="d19_dtinicio")
	private Date dtInicio;
	
	@Column(name="d19_dtfim")
	private Date dtFim;

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public AppMonitoramento getCdMonitoramento() {
		return cdMonitoramento;
	}

	public void setCdMonitoramento(AppMonitoramento cdMonitoramento) {
		this.cdMonitoramento = cdMonitoramento;
	}

	public Long getCdAvaliacao() {
		return cdAvaliacao;
	}

	public void setCdAvaliacao(Long cdAvaliacao) {
		this.cdAvaliacao = cdAvaliacao;
	}

	public String getNmAvaliacao() {
		return nmAvaliacao;
	}

	public void setNmAvaliacao(String nmAvaliacao) {
		this.nmAvaliacao = nmAvaliacao;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdAvaliacao == null) ? 0 : cdAvaliacao.hashCode());
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
		AppAvaliacao other = (AppAvaliacao) obj;
		if (cdAvaliacao == null) {
			if (other.cdAvaliacao != null)
				return false;
		} else if (!cdAvaliacao.equals(other.cdAvaliacao))
			return false;
		return true;
	}
	
	
	
	
	

}
