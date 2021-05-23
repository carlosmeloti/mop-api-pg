package br.embrapa.repository.projections;

public class ResumoVerificadoresMonitoramentoTemplate {
	
	private Long cdVeriMod;
	private Long cdTipoDeVerificador;
	private Long cdTemplate;
	private Long cdVerificador;
	private String codalfa;
	private String sigla;
	private String nmVerificador;

	public ResumoVerificadoresMonitoramentoTemplate(Long cdVeriMod, Long cdTipoDeVerificador, 
			Long cdTemplate, Long cdVerificador, String codalfa, String sigla, String nmVerificador) {
		
		this.cdVeriMod = cdVerificador;
		this.cdTipoDeVerificador = cdTipoDeVerificador;
		this.cdTemplate = cdTemplate;
		this.cdVerificador = cdVerificador;
		this.codalfa = codalfa;
		this.sigla = sigla;
		this.nmVerificador = nmVerificador;
	}


		
	public Long getCdVeriMod() {
		return cdVeriMod;
	}


	public void setCdVeriMod(Long cdVeriMod) {
		this.cdVeriMod = cdVeriMod;
	}




	public Long getCdTipoDeVerificador() {
		return cdTipoDeVerificador;
	}



	public void setCdTipoDeVerificador(Long cdTipoDeVerificador) {
		this.cdTipoDeVerificador = cdTipoDeVerificador;
	}

	


	public Long getCdTemplate() {
		return cdTemplate;
	}



	public void setCdTemplate(Long cdTemplate) {
		this.cdTemplate = cdTemplate;
	}



	public Long getCdVerificador() {
		return cdVerificador;
	}

	public void setCdVerificador(Long cdVerificador) {
		this.cdVerificador = cdVerificador;
	}

	public String getCodalfa() {
		return codalfa;
	}

	public void setCodalfa(String codalfa) {
		this.codalfa = codalfa;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNmVerificador() {
		return nmVerificador;
	}

	public void setNmVerificador(String nmVerificador) {
		this.nmVerificador = nmVerificador;
	}
	
	
	
	
	
	
	
}
