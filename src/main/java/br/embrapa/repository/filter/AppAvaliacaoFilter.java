package br.embrapa.repository.filter;

public class AppAvaliacaoFilter {
	
	private String nmAvaliacao;
	private String nmMonitoramento;
	private Long cdMonitoramento;
	private Long cdEmpresa;
	
	

	public Long getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(Long cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getNmAvaliacao() {
		return nmAvaliacao;
	}

	public void setNmAvaliacao(String nmAvaliacao) {
		this.nmAvaliacao = nmAvaliacao;
	}

	public String getNmMonitoramento() {
		return nmMonitoramento;
	}

	public void setNmMonitoramento(String nmMonitoramento) {
		this.nmMonitoramento = nmMonitoramento;
	}

	public Long getCdMonitoramento() {
		return cdMonitoramento;
	}

	public void setCdMonitoramento(Long cdMonitoramento) {
		this.cdMonitoramento = cdMonitoramento;
	}
	
	
	
	
	
	
	

}
