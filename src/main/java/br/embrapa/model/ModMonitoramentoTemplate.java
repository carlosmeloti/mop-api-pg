package br.embrapa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="d14_template")
public class ModMonitoramentoTemplate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="d14_cdtemplate")
	private Long cdTemplate;
	
	@Column(name="d14_nmtemplate")
	private String nmTemplate;
	
	@ManyToOne
	@JoinColumn(name="d14_cdtipoverificador")
	private CadTipoDeVerificador cdTipoDeVerificador;

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

	public CadTipoDeVerificador getCdTipoDeVerificador() {
		return cdTipoDeVerificador;
	}

	public void setCdTipoDeVerificador(CadTipoDeVerificador cdTipoDeVerificador) {
		this.cdTipoDeVerificador = cdTipoDeVerificador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdTemplate == null) ? 0 : cdTemplate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModMonitoramentoTemplate other = (ModMonitoramentoTemplate) obj;
		if (cdTemplate == null) {
			if (other.cdTemplate != null)
				return false;
		} else if (!cdTemplate.equals(other.cdTemplate))
			return false;
		return true;
	}

	
	
	
	
}
