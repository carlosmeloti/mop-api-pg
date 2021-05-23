package br.embrapa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AssociarVerificadorAosLocaisMateriais.class)
public abstract class AssociarVerificadorAosLocaisMateriais_ {

	public static volatile SingularAttribute<AssociarVerificadorAosLocaisMateriais, String> nm_material;
	public static volatile SingularAttribute<AssociarVerificadorAosLocaisMateriais, Long> id;
	public static volatile SingularAttribute<AssociarVerificadorAosLocaisMateriais, AssociarVerificadorAosLocais> id_verificador_local;
	public static volatile SingularAttribute<AssociarVerificadorAosLocaisMateriais, Long> id_material;

}

