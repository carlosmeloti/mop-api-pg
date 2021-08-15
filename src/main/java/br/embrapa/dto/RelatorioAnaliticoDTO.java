package br.embrapa.dto;

import java.util.Date;

public class RelatorioAnaliticoDTO {
	
	private String d24_nmempresa;
	private String d18_nmmonitoramento;
	private String d19_nmavaliacao;
	private Date d19_dtinicio;
	private Date d19_dtfim;
	private String p01_codalfa;
	private String p01_nmverificador;
	private Integer p21_nrconf;
	private Integer p21_nrnaoconf;
	private Integer p21_nrobservacoes;
	private Integer p01_graco;
	private String p21_resultado;
	
	public RelatorioAnaliticoDTO(String d24_nmempresa, String d18_nmmonitoramento, String d19_nmavaliacao,
			Date d19_dtinicio, Date d19_dtfim, String p01_codalfa, String p01_nmverificador, Integer p21_nrconf,
			Integer p21_nrnaoconf, Integer p21_nrobservacoes, Integer p01_graco, String p21_resultado) {
		this.d24_nmempresa = d24_nmempresa;
		this.d18_nmmonitoramento = d18_nmmonitoramento;
		this.d19_nmavaliacao = d19_nmavaliacao;
		this.d19_dtinicio = d19_dtinicio;
		this.d19_dtfim = d19_dtfim;
		this.p01_codalfa = p01_codalfa;
		this.p01_nmverificador = p01_nmverificador;
		this.p21_nrconf = p21_nrconf;
		this.p21_nrnaoconf = p21_nrnaoconf;
		this.p21_nrobservacoes = p21_nrobservacoes;
		this.p01_graco = p01_graco;
		this.p21_resultado = p21_resultado;
	}

	public String getD24_nmempresa() {
		return d24_nmempresa;
	}

	public void setD24_nmempresa(String d24_nmempresa) {
		this.d24_nmempresa = d24_nmempresa;
	}

	public String getD18_nmmonitoramento() {
		return d18_nmmonitoramento;
	}

	public void setD18_nmmonitoramento(String d18_nmmonitoramento) {
		this.d18_nmmonitoramento = d18_nmmonitoramento;
	}

	public String getD19_nmavaliacao() {
		return d19_nmavaliacao;
	}

	public void setD19_nmavaliacao(String d19_nmavaliacao) {
		this.d19_nmavaliacao = d19_nmavaliacao;
	}

	public Date getD19_dtinicio() {
		return d19_dtinicio;
	}

	public void setD19_dtinicio(Date d19_dtinicio) {
		this.d19_dtinicio = d19_dtinicio;
	}

	public Date getD19_dtfim() {
		return d19_dtfim;
	}

	public void setD19_dtfim(Date d19_dtfim) {
		this.d19_dtfim = d19_dtfim;
	}

	public String getP01_codalfa() {
		return p01_codalfa;
	}

	public void setP01_codalfa(String p01_codalfa) {
		this.p01_codalfa = p01_codalfa;
	}

	public String getP01_nmverificador() {
		return p01_nmverificador;
	}

	public void setP01_nmverificador(String p01_nmverificador) {
		this.p01_nmverificador = p01_nmverificador;
	}

	public Integer getP21_nrconf() {
		return p21_nrconf;
	}

	public void setP21_nrconf(Integer p21_nrconf) {
		this.p21_nrconf = p21_nrconf;
	}

	public Integer getP21_nrnaoconf() {
		return p21_nrnaoconf;
	}

	public void setP21_nrnaoconf(Integer p21_nrnaoconf) {
		this.p21_nrnaoconf = p21_nrnaoconf;
	}

	public Integer getP21_nrobservacoes() {
		return p21_nrobservacoes;
	}

	public void setP21_nrobservacoes(Integer p21_nrobservacoes) {
		this.p21_nrobservacoes = p21_nrobservacoes;
	}

	public Integer getP01_graco() {
		return p01_graco;
	}

	public void setP01_graco(Integer p01_graco) {
		this.p01_graco = p01_graco;
	}

	public String getP21_resultado() {
		return p21_resultado;
	}

	public void setP21_resultado(String p21_resultado) {
		this.p21_resultado = p21_resultado;
	}
	
	
	
	
}
