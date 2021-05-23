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
@Table(name="r16_verificador_local_material_m")
public class AssociarVerificadorAosLocaisMateriais {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_r15_verificador_local_m", referencedColumnName = "r15_id_verificador_local")
	private AssociarVerificadorAosLocais id_verificador_local;
	
	@Column(name="id_material")
	private Long id_material;
	
	@Column(name="nm_material")
	private String nm_material;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AssociarVerificadorAosLocais getId_verificador_local() {
		return id_verificador_local;
	}

	public void setId_verificador_local(AssociarVerificadorAosLocais id_verificador_local) {
		this.id_verificador_local = id_verificador_local;
	}

	public Long getId_material() {
		return id_material;
	}

	public void setId_material(Long id_material) {
		this.id_material = id_material;
	}

	public String getNm_material() {
		return nm_material;
	}

	public void setNm_material(String nm_material) {
		this.nm_material = nm_material;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AssociarVerificadorAosLocaisMateriais other = (AssociarVerificadorAosLocaisMateriais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
