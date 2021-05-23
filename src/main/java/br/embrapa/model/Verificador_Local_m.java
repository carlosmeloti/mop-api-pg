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
public class Verificador_Local_m {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "r15_id_verificador_local")
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "r15_cdempresa", referencedColumnName="d24_cdempresa")
	private CadEmpresa cdEmpresa;
	 
	@ManyToOne
	@JoinColumn(name= "r15_id_Verificador_m" , referencedColumnName = "p01_id_Verificador_m")
	private Verificador_m codigoVerificadorLocal;
	
	@ManyToOne
	@JoinColumn(name= "r15_cdtipoverificador" , referencedColumnName = "d02_cdtipoverificador")
	private CadTipoDeVerificador cdTipoDeVerificador;
	
	@ManyToOne
	@JoinColumn(name = "r15_cdlocal1" , referencedColumnName = "d03_cdlocal1")
	private ModLocal1 cdLocal1;
	
	@ManyToOne
	@JoinColumn(name = "r15_cdlocal2" , referencedColumnName = "d04_cdlocal2")
	private ModLocal2 cdLocal2;
	
	@ManyToOne
	@JoinColumn(name = "r15_cdlocal3" , referencedColumnName = "d05_cdlocal3")
	private ModLocal3 cdLocal3;
	
	@ManyToOne
	@JoinColumn(name = "r15_cdtipometodo", referencedColumnName = "d07_cdtipometodo")
	private CadTipoDeMetodo cdTipoDeMetodo;
	
	@Column(name = "r15_txmetodologia")
	private String txMetodologia;
	
	@ManyToOne
	@JoinColumn(name = "r15_cdfrequencia", referencedColumnName = "d08_cdfrequencia")
	private CadFrequencia cdFrequencia;
	
	@ManyToOne
	@JoinColumn(name = "r15_cdamostragem", referencedColumnName = "d06_cdamostragem")
	private CadAmostragem cdAmostragem;
	
	/*@ManyToOne
	@JoinColumn(name = "r15_cdmaterial1", referencedColumnName = "d09_cdmaterial")
	private CadMaterial cdMaterial1;
	
	@ManyToOne
	@JoinColumn(name = "r15_cdmaterial2", referencedColumnName = "d09_cdmaterial")
	private CadMaterial cdMaterial2;
	
	@ManyToOne
	@JoinColumn(name = "r15_cdmaterial3", referencedColumnName = "d09_cdmaterial")
	private CadMaterial cdMaterial3;*/
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public Verificador_m getCodigoVerificadorLocal() {
		return codigoVerificadorLocal;
	}

	public void setCodigoVerificadorLocal(Verificador_m codigoVerificadorLocal) {
		this.codigoVerificadorLocal = codigoVerificadorLocal;
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

	public String getTxMetodologia() {
		return txMetodologia;
	}

	public void setTxMetodologia(String txMetodologia) {
		this.txMetodologia = txMetodologia;
	}

	public CadFrequencia getCdFrequencia() {
		return cdFrequencia;
	}

	public void setCdFrequencia(CadFrequencia cdFrequencia) {
		this.cdFrequencia = cdFrequencia;
	}

	public CadAmostragem getCdAmostragem() {
		return cdAmostragem;
	}

	public void setCdAmostragem(CadAmostragem cdAmostragem) {
		this.cdAmostragem = cdAmostragem;
	}


}
