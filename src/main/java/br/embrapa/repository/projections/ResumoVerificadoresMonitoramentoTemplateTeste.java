package br.embrapa.repository.projections;

import java.math.BigDecimal;

public class ResumoVerificadoresMonitoramentoTemplateTeste {
	
	
	private String codalfa;
	private String nmNivelDeAvaliacao;
	private BigDecimal p01_graco;
	private String txColetaAgrupada;
	private String txColetaAnalitica;
	
	public ResumoVerificadoresMonitoramentoTemplateTeste(String codalfa, String nmNivelDeAvaliacao,
			BigDecimal p01_graco, String txColetaAgrupada, String txColetaAnalitica) {
		this.codalfa = codalfa;
		this.nmNivelDeAvaliacao = nmNivelDeAvaliacao;
		this.p01_graco = p01_graco;
		this.txColetaAgrupada = txColetaAgrupada;
		this.txColetaAnalitica = txColetaAnalitica;
	}

	public String getCodalfa() {
		return codalfa;
	}

	public void setCodalfa(String codalfa) {
		this.codalfa = codalfa;
	}

	public String getNmNivelDeAvaliacao() {
		return nmNivelDeAvaliacao;
	}

	public void setNmNivelDeAvaliacao(String nmNivelDeAvaliacao) {
		this.nmNivelDeAvaliacao = nmNivelDeAvaliacao;
	}

	public BigDecimal getP01_graco() {
		return p01_graco;
	}

	public void setP01_graco(BigDecimal p01_graco) {
		this.p01_graco = p01_graco;
	}

	public String getTxColetaAgrupada() {
		return txColetaAgrupada;
	}

	public void setTxColetaAgrupada(String txColetaAgrupada) {
		this.txColetaAgrupada = txColetaAgrupada;
	}

	public String getTxColetaAnalitica() {
		return txColetaAnalitica;
	}

	public void setTxColetaAnalitica(String txColetaAnalitica) {
		this.txColetaAnalitica = txColetaAnalitica;
	}

	
	
}
