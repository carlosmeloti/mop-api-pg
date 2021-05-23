package br.embrapa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppVerificadoresMonitoramento.class)
public abstract class AppVerificadoresMonitoramento_ {

	public static volatile SingularAttribute<AppVerificadoresMonitoramento, CadTipoDeVerificador> cdTipoDeVerificador;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, Verificador_m> cdVerificador;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, String> txColetaAnalitica;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, String> txColetaAgrupada;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, ModNivel1> cdNivel1;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, ModNivel2> cdNivel2;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, Long> cdVeriMod;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, ModNivel3> cdNivel3;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, ModNivel4> cdNivel4;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, Boolean> lgDadosAnaliticos;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, CadEmpresa> cdEmpresa;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, Boolean> lgDadosAgrupados;
	public static volatile SingularAttribute<AppVerificadoresMonitoramento, AppMonitoramento> cdMonitoramento;

}

