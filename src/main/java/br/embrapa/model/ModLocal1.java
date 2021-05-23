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
@Table(name="d03_local1_m")
public class ModLocal1 {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="d03_cdlocal1")
	private Long cdLocal1;
	
	@ManyToOne
	@JoinColumn(name="d03_cdempresa")
	private CadEmpresa cdEmpresa;
	
	@Column(name="d03_nmlocal1")
	private String nmlocal1;

	public Long getCdLocal1() {
		return cdLocal1;
	}

	public void setCdLocal1(Long cdLocal1) {
		this.cdLocal1 = cdLocal1;
	}

	public CadEmpresa getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(CadEmpresa cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getNmlocal1() {
		return nmlocal1;
	}

	public void setNmlocal1(String nmlocal1) {
		this.nmlocal1 = nmlocal1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdLocal1 == null) ? 0 : cdLocal1.hashCode());
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
		ModLocal1 other = (ModLocal1) obj;
		if (cdLocal1 == null) {
			if (other.cdLocal1 != null)
				return false;
		} else if (!cdLocal1.equals(other.cdLocal1))
			return false;
		return true;
	}

	
	
}