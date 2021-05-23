package br.embrapa.repository.projections;

public class ResumoVerificador_m {

	private Long codigo;
	private Long cdVerificador;
	private String codalfa;
	private String sigla;
	private String nmTipoDeVerificador;
	private String nmVerificador;
	
		
	public ResumoVerificador_m(Long codigo, Long cdVerificador, String codalfa, String sigla,String nmTipoDeVerificador, 
			String nmVerificador) {
		this.codigo = codigo;
		this.cdVerificador = cdVerificador; 
		this.codalfa = codalfa;
		this.sigla = sigla;
		this.nmTipoDeVerificador = nmTipoDeVerificador;
		this.nmVerificador = nmVerificador;
	}
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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


	public String getNmTipoDeVerificador() {
		return nmTipoDeVerificador;
	}


	public void setNmTipoDeVerificador(String nmTipoDeVerificador) {
		this.nmTipoDeVerificador = nmTipoDeVerificador;
	}


	public String getNmVerificador() {
		return nmVerificador;
	}


	public void setNmVerificador(String nmVerificador) {
		this.nmVerificador = nmVerificador;
	}


	
	
	
	
}
