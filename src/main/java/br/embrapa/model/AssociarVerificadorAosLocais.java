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
@Table(name="r15_verificador_local_m")
public class AssociarVerificadorAosLocais {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="r15_id_verificador_local")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="r15_cdempresa", referencedColumnName = "d24_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@ManyToOne
	@JoinColumn(name="r15_id_Verificador_m", referencedColumnName = "p01_id_Verificador_m")
	private Verificador_m idVerificador; 
	
	@ManyToOne
	@JoinColumn(name="r15_cdtipoverificador", referencedColumnName = "d02_cdtipoverificador")
	private CadTipoDeVerificador cdTipoDeVerificador;
	
	@ManyToOne
	@JoinColumn(name="r15_cdlocal1", referencedColumnName = "d03_cdlocal1")
	private ModLocal1 cdLocal1;
	
	@ManyToOne
	@JoinColumn(name="r15_cdlocal2", referencedColumnName = "d04_cdlocal2")
	private ModLocal2 cdLocal2;
	
	@ManyToOne
	@JoinColumn(name="r15_cdlocal3", referencedColumnName = "d05_cdlocal3")
	private ModLocal3 cdLocal3;
	
	@ManyToOne
	@JoinColumn(name="r15_cdtipometodo", referencedColumnName="d07_cdtipometodo")
	private CadTipoDeMetodo cdTipoDeMetodo;
	
	@ManyToOne
	@JoinColumn(name="r15_cdamostragem", referencedColumnName="d06_cdamostragem")
	private CadAmostragem cdAmostragem;
	
	@ManyToOne
	@JoinColumn(name="r15_cdfrequencia", referencedColumnName = "d08_cdfrequencia")
	private CadFrequencia cdFrequencia;
	
	@Column(name="r15_txmetodologia")
	private String txMetodologia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public Verificador_m getIdVerificador() {
		return idVerificador;
	}

	public void setIdVerificador(Verificador_m idVerificador) {
		this.idVerificador = idVerificador;
	}

	public CadTipoDeVerificador getCdTipoDeVerificador() {
		return cdTipoDeVerificador;
	}

	public void setCdTipoDeVerificador(CadTipoDeVerificador cdTipoDeVerificador) {
		this.cdTipoDeVerificador = cdTipoDeVerificador;
	}

	public ModLocal1 getCdLocal1() {
		return cdLocal1;
	}

	public void setCdLocal1(ModLocal1 cdLocal1) {
		this.cdLocal1 = cdLocal1;
	}

	public ModLocal2 getCdLocal2() {
		return cdLocal2;
	}

	public void setCdLocal2(ModLocal2 cdLocal2) {
		this.cdLocal2 = cdLocal2;
	}

	public ModLocal3 getCdLocal3() {
		return cdLocal3;
	}

	public void setCdLocal3(ModLocal3 cdLocal3) {
		this.cdLocal3 = cdLocal3;
	}

	public CadTipoDeMetodo getCdTipoDeMetodo() {
		return cdTipoDeMetodo;
	}

	public void setCdTipoDeMetodo(CadTipoDeMetodo cdTipoDeMetodo) {
		this.cdTipoDeMetodo = cdTipoDeMetodo;
	}

	public CadAmostragem getCdAmostragem() {
		return cdAmostragem;
	}

	public void setCdAmostragem(CadAmostragem cdAmostragem) {
		this.cdAmostragem = cdAmostragem;
	}

	public CadFrequencia getCdFrequencia() {
		return cdFrequencia;
	}

	public void setCdFrequencia(CadFrequencia cdFrequencia) {
		this.cdFrequencia = cdFrequencia;
	}

	public String getTxMetodologia() {
		return txMetodologia;
	}

	public void setTxMetodologia(String txMetodologia) {
		this.txMetodologia = txMetodologia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AssociarVerificadorAosLocais other = (AssociarVerificadorAosLocais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

}
