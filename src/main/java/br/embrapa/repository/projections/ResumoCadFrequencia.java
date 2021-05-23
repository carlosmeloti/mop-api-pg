package br.embrapa.repository.projections;

import br.embrapa.model.CadEmpresa;

public class ResumoCadFrequencia {

	private Long cdFrequencia;
	private String cdEmpresa;
	private String nmFrequencia;
	
	
	
	public ResumoCadFrequencia() {
	}

	public ResumoCadFrequencia(Long cdFrequencia, String cdEmpresa, String nmFrequencia) {
		this.cdFrequencia = cdFrequencia;
		this.cdEmpresa = cdEmpresa;
		this.nmFrequencia = nmFrequencia;
	}

	public Long getCdFrequencia() {
		return cdFrequencia;
	}

	public void setCdFrequencia(Long cdFrequencia) {
		this.cdFrequencia = cdFrequencia;
	}

	public String getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(String cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getNmFrequencia() {
		return nmFrequencia;
	}

	public void setNmFrequencia(String nmFrequencia) {
		this.nmFrequencia = nmFrequencia;
	}
	
	
	
	

}
