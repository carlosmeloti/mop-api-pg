package br.embrapa.repository.projections;

public class ResumoModMonitoramentoTemplate {


	private Long cdTemplate;
	private String nmTemplate;
	private Long cdTipoDeVerificador;
	
	
	public ResumoModMonitoramentoTemplate(Long cdTemplate, String nmTemplate, Long cdTipoDeVerificador) {
		this.cdTemplate = cdTemplate;
		this.nmTemplate = nmTemplate;
		this.cdTipoDeVerificador = cdTipoDeVerificador;
	}


	public Long getCdTemplate() {
		return cdTemplate;
	}


	public void setCdTemplate(Long cdTemplate) {
		this.cdTemplate = cdTemplate;
	}


	public String getNmTemplate() {
		return nmTemplate;
	}


	public void setNmTemplate(String nmTemplate) {
		this.nmTemplate = nmTemplate;
	}


	public Long getCdTipoDeVerificador() {
		return cdTipoDeVerificador;
	}


	public void setCdTipoDeVerificador(Long cdTipoDeVerificador) {
		this.cdTipoDeVerificador = cdTipoDeVerificador;
	}
	
	
	
	
	
}
