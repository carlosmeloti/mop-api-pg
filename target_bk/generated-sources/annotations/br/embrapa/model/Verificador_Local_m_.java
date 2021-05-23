package br.embrapa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Verificador_Local_m.class)
public abstract class Verificador_Local_m_ {

	public static volatile SingularAttribute<Verificador_Local_m, CadFrequencia> cdFrequencia;
	public static volatile SingularAttribute<Verificador_Local_m, Long> codigo;
	public static volatile SingularAttribute<Verificador_Local_m, CadTipoDeVerificador> cdTipoDeVerificador;
	public static volatile SingularAttribute<Verificador_Local_m, CadMaterial> cdMaterial1;
	public static volatile SingularAttribute<Verificador_Local_m, CadMaterial> cdMaterial2;
	public static volatile SingularAttribute<Verificador_Local_m, CadMaterial> cdMaterial3;
	public static volatile SingularAttribute<Verificador_Local_m, Verificador_m> codigoVerificadorLocal;
	public static volatile SingularAttribute<Verificador_Local_m, String> txMetodologia;
	public static volatile SingularAttribute<Verificador_Local_m, CadEmpresa> cdEmpresa;
	public static volatile SingularAttribute<Verificador_Local_m, ModLocal2> cdLocal2;
	public static volatile SingularAttribute<Verificador_Local_m, ModLocal3> cdLocal3;
	public static volatile SingularAttribute<Verificador_Local_m, ModLocal1> cdLocal1;
	public static volatile SingularAttribute<Verificador_Local_m, CadAmostragem> cdAmostragem;
	public static volatile SingularAttribute<Verificador_Local_m, CadTipoDeMetodo> cdTipoDeMetodo;

}

