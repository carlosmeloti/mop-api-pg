package br.embrapa.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppMonitoramento.class)
public abstract class AppMonitoramento_ {

	public static volatile SingularAttribute<AppMonitoramento, String> nmMonitoramento;
	public static volatile SingularAttribute<AppMonitoramento, CadEmpresa> cdEmpresa;
	public static volatile SingularAttribute<AppMonitoramento, CadTipoDeVerificador> cdTipoDeVerificador;
	public static volatile SingularAttribute<AppMonitoramento, Long> cdMonitoramento;
	public static volatile SingularAttribute<AppMonitoramento, Date> dtCriacao;
	public static volatile SingularAttribute<AppMonitoramento, ModMonitoramentoTemplate> cdTemplate;
	public static volatile SingularAttribute<AppMonitoramento, String> txLocal;

}

