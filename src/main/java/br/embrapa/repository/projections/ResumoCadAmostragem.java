package br.embrapa.repository.projections;

public class ResumoCadAmostragem {
	
	private Long cdAmostragem;
	private String nmAmostragem;
	private Long cdEmpresa;
	
	
	public ResumoCadAmostragem(Long cdAmostragem, String nmAmostragem, Long cdEmpresa) {
		this.cdAmostragem = cdAmostragem;
		this.nmAmostragem = nmAmostragem;
		this.cdEmpresa = cdEmpresa;
	}
	
	public Long getCdAmostragem() {
		return cdAmostragem;
	}
	public void setCdAmostragem(Long cdAmostragem) {
		this.cdAmostragem = cdAmostragem;
	}
	public String getNmAmostragem() {
		return nmAmostragem;
	}
	public void setNmAmostragem(String nmAmostragem) {
		this.nmAmostragem = nmAmostragem;
	}
	public Long getCdEmpresa() {
		return cdEmpresa;
	}
	public void setCdEmpresa(Long cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	
	
	
	
}
