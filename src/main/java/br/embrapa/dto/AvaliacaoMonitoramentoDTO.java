package br.embrapa.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avaliacao_monitoramento")
public class AvaliacaoMonitoramentoDTO {

	@Id
	private Long id;
	private Long cdempresa;
	private Long cdverimod;
	private Long cdtipoverificador;
	private Long cdmonitoramento;
	private Long cdavaliacao;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCdempresa() {
		return cdempresa;
	}
	public void setCdempresa(Long cdempresa) {
		this.cdempresa = cdempresa;
	}
	public Long getCdverimod() {
		return cdverimod;
	}
	public void setCdverimod(Long cdverimod) {
		this.cdverimod = cdverimod;
	}
	public Long getCdtipoverificador() {
		return cdtipoverificador;
	}
	public void setCdtipoverificador(Long cdtipoverificador) {
		this.cdtipoverificador = cdtipoverificador;
	}
	public Long getCdmonitoramento() {
		return cdmonitoramento;
	}
	public void setCdmonitoramento(Long cdmonitoramento) {
		this.cdmonitoramento = cdmonitoramento;
	}
	public Long getCdavaliacao() {
		return cdavaliacao;
	}
	public void setCdavaliacao(Long cdavaliacao) {
		this.cdavaliacao = cdavaliacao;
	}
	
	
	
	
}
