package br.embrapa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppColetaDeDados.class)
public abstract class AppColetaDeDados_ {

	public static volatile SingularAttribute<AppColetaDeDados, AppAvaliacao> cdAvaliacao;
	public static volatile SingularAttribute<AppColetaDeDados, CadEmpresa> cdEmpresa;
	public static volatile SingularAttribute<AppColetaDeDados, Long> cdColetaDeDaDos;
	public static volatile SingularAttribute<AppColetaDeDados, CadTipoDeVerificador> cdTipoDeVerificador;
	public static volatile SingularAttribute<AppColetaDeDados, Verificador_m> id_Verificador_m;
	public static volatile SingularAttribute<AppColetaDeDados, AppMonitoramento> cdMonitoramento;
	public static volatile SingularAttribute<AppColetaDeDados, Integer> nrObservacoes;
	public static volatile SingularAttribute<AppColetaDeDados, Integer> nrNaoConformidades;
	public static volatile SingularAttribute<AppColetaDeDados, String> txObservacao;

}

