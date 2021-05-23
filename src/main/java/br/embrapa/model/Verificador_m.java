package br.embrapa.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="p01_verificador_m")
public class Verificador_m {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="p01_id_Verificador_m")
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name="p01_cdempresa")
	private CadEmpresa cdEmpresa;

	
	@ManyToOne
	@JoinColumn(name="p01_cdtipoverificador")
	private CadTipoDeVerificador cdTipoDeVerificador;

	@Column(name="p01_cdverificador")
	private Long cdVerificador;
	
	@ManyToOne
	@JoinColumn(name="p01_cdnivelavaliacao", referencedColumnName = "d20_cdnivelavaliacao" )
	private CadNivelDeAvaliacao cadNivelDeAvaliacao; 
	
	@Column(name="p01_codalfa")
	private String codalfa;
	
	@Column(name="p01_nmverificador")
	private String nmverificador;
	
	@Column(name="p01_limiar")
	private String limiar;
	
	@Column(name="p01_graco")
	private BigDecimal p01_graco;
	
	

	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public CadNivelDeAvaliacao getCadNivelDeAvaliacao() {
		return cadNivelDeAvaliacao;
	}

	public void setCadNivelDeAvaliacao(CadNivelDeAvaliacao cadNivelDeAvaliacao) {
		this.cadNivelDeAvaliacao = cadNivelDeAvaliacao;
	}

	public String getCodalfa() {
		return codalfa;
	}

	public void setCodalfa(String codalfa) {
		this.codalfa = codalfa;
	}

	public String getNmverificador() {
		return nmverificador;
	}

	public void setNmverificador(String nmverificador) {
		this.nmverificador = nmverificador;
	}

	public String getLimiar() {
		return limiar;
	}

	public void setLimiar(String limiar) {
		this.limiar = limiar;
	}

	public BigDecimal getP01_graco() {
		return p01_graco;
	}

	public void setP01_graco(BigDecimal p01_graco) {
		this.p01_graco = p01_graco;
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

	public Long getCdVerificador() {
		return cdVerificador;
	}

	public void setCdVerificador(Long cdVerificador) {
		this.cdVerificador = cdVerificador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Verificador_m other = (Verificador_m) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	

	
	

	
	
	
}