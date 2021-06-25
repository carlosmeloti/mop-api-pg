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
@Table(name="p21_coleta")
public class AppColetaDeDados {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="p21_cdcoletadedados")  
	private Long cdColetaDeDaDos;
	
	@ManyToOne
	@JoinColumn(name="p21_cdempresa", referencedColumnName="d24_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@ManyToOne
	@JoinColumn(name="p21_id_Verificador_m", referencedColumnName="p01_id_Verificador_m")
	private Verificador_m id_Verificador_m;
	
	@ManyToOne
	@JoinColumn(name="p21_cdtipoverificador", referencedColumnName ="d02_cdtipoverificador")
	private CadTipoDeVerificador cdTipoDeVerificador;
	
	@ManyToOne
	@JoinColumn(name="p21_cdmonitoramento", referencedColumnName = "d18_cdmonitoramento")
	private AppMonitoramento cdMonitoramento;
	
	@ManyToOne
	@JoinColumn(name="p21_cdavaliacao", referencedColumnName = "d19_cdavaliacao")
	private AppAvaliacao cdAvaliacao;
	
	@Column(name="p21_nrobservacoes") 
	private Integer nrObservacoes;
	
	@Column(name="p21_nrnaoconf")
	private Integer nrNaoConformidades;
	
	@Column(name="p21_txobservacao")
	private String txObservacao;
	
	public Long getCdColetaDeDaDos() {
		return cdColetaDeDaDos;
	}
	public void setCdColetaDeDaDos(Long cdColetaDeDaDos) {
		this.cdColetaDeDaDos = cdColetaDeDaDos;
	}
	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}
	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	public CadTipoDeVerificador getCdTipoDeVerificador() {
		return cdTipoDeVerificador;
	}
	public void setCdTipoDeVerificador(CadTipoDeVerificador cdTipoDeVerificador) {
		this.cdTipoDeVerificador = cdTipoDeVerificador;
	}
	public AppAvaliacao getCdAvaliacao() {
		return cdAvaliacao;
	}
	public Verificador_m getId_Verificador_m() {
		return id_Verificador_m;
	}
	public void setId_Verificador_m(Verificador_m id_Verificador_m) {
		this.id_Verificador_m = id_Verificador_m;
	}
	public AppMonitoramento getCdMonitoramento() {
		return cdMonitoramento;
	}
	public void setCdMonitoramento(AppMonitoramento cdMonitoramento) {
		this.cdMonitoramento = cdMonitoramento;
	}
	public void setCdAvaliacao(AppAvaliacao cdAvaliacao) {
		this.cdAvaliacao = cdAvaliacao;
	}
	public Integer getNrObservacoes() {
		return nrObservacoes;
	}
	public void setNrObservacoes(Integer nrObservacoes) {
		this.nrObservacoes = nrObservacoes;
	}
	public Integer getNrNaoConformidades() {
		return nrNaoConformidades;
	}
	public void setNrNaoConformidades(Integer nrNaoConformidades) {
		this.nrNaoConformidades = nrNaoConformidades;
	}
	public String getTxObservacao() {
		return txObservacao;
	}
	public void setTxObservacao(String txObservacao) {
		this.txObservacao = txObservacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdColetaDeDaDos == null) ? 0 : cdColetaDeDaDos.hashCode());
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
		AppColetaDeDados other = (AppColetaDeDados) obj;
		if (cdColetaDeDaDos == null) {
			if (other.cdColetaDeDaDos != null)
				return false;
		} else if (!cdColetaDeDaDos.equals(other.cdColetaDeDaDos))
			return false;
		return true;
	}
	

}
