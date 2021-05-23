package br.embrapa.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppAvaliacao.class)
public abstract class AppAvaliacao_ {

	public static volatile SingularAttribute<AppAvaliacao, Long> cdAvaliacao;
	public static volatile SingularAttribute<AppAvaliacao, CadEmpresa> cdEmpresa;
	public static volatile SingularAttribute<AppAvaliacao, AppMonitoramento> cdMonitoramento;
	public static volatile SingularAttribute<AppAvaliacao, String> nmAvaliacao;
	public static volatile SingularAttribute<AppAvaliacao, Date> dtInicio;
	public static volatile SingularAttribute<AppAvaliacao, Date> dtFim;

}

