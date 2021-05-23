package br.embrapa.dto;

import java.math.BigDecimal;

public class TodosOsVerificadores {
	
	
	private String codalfa;
	private String nmNivelDeAvaliacao;
	private BigDecimal p01_graco;
	private String txColetaAnalitica;
	private String txColetaAgrupada;
	private String nmverificador;
	
	public TodosOsVerificadores(String codalfa, String nmNivelDeAvaliacao,
			BigDecimal p01_graco, String txColetaAnalitica, String txColetaAgrupada, 
			String nmverificador) {
		
		this.codalfa = codalfa;
		this.nmNivelDeAvaliacao = nmNivelDeAvaliacao;
		this.p01_graco = p01_graco;
		this.txColetaAgrupada = txColetaAgrupada;
		this.txColetaAnalitica = txColetaAnalitica;
		this.nmverificador = nmverificador;
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



	public String getTxColetaAnalitica() {
		return txColetaAnalitica;
	}



	public void setTxColetaAnalitica(String txColetaAnalitica) {
		this.txColetaAnalitica = txColetaAnalitica;
	}



	public String getTxColetaAgrupada() {
		return txColetaAgrupada;
	}



	public void setTxColetaAgrupada(String txColetaAgrupada) {
		this.txColetaAgrupada = txColetaAgrupada;
	}



	public String getNmverificador() {
		return nmverificador;
	}



	public void setNmverificador(String nmverificador) {
		this.nmverificador = nmverificador;
	}
	
	
		

}
