package br.embrapa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ModVerificadoresMonitoramentoTemplate.class)
public abstract class ModVerificadoresMonitoramentoTemplate_ {

	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, CadTipoDeVerificador> cdTipoDeVerificador;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, Verificador_m> cdVerificador;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, String> txColetaAnalitica;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, String> txColetaAgrupada;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, ModMonitoramentoTemplate> cdTemplate;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, ModNivel1> cdNivel1;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, ModNivel2> cdNivel2;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, Long> cdVeriMod;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, ModNivel3> cdNivel3;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, ModNivel4> cdNivel4;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, Boolean> lgDadosAnaliticos;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, CadEmpresa> cdEmpresa;
	public static volatile SingularAttribute<ModVerificadoresMonitoramentoTemplate, Boolean> lgDadosAgrupados;

}

