package br.embrapa.repository.consultas;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.embrapa.dto.RelatorioAnaliticoDTO;
import br.embrapa.dto.TodosOsVerificadores;
import br.embrapa.model.CadNivelDeAvaliacao_;
import br.embrapa.model.CadTipoDeVerificador_;
import br.embrapa.model.ModMonitoramentoTemplate_;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate_;
import br.embrapa.model.Verificador_m_;
import br.embrapa.repository.filter.ModVerificadoresMonitoramentoTemplateFilter;
import br.embrapa.repository.projections.CountVerificadores;
import br.embrapa.repository.projections.ResumoVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.projections.ResumoVerificadoresMonitoramentoTemplateTeste;
import br.embrapa.resource.AppAvaliacaoResource;

public class ModVerificadoresMonitoramentoTemplateRepositoryImpl implements ModVerificadoresMonitoramentoTemplateRepositoryQuery {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModVerificadoresMonitoramentoTemplateRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager manager;	

	@SuppressWarnings("unchecked")
	public List<TodosOsVerificadores> listaVerificadores(Long cdTemplate, boolean ordCatAva, boolean ordHierarquica){
		
		LOGGER.info("BUSCANDO VERIFICADORES PARA MONTAGEM DO RELATORIO");
				
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct(vt.r17_cdverimod), v.p01_codalfa as codalfa, ");
		sb.append("na.d20_nmnivelavaliacao as nmNivelDeAvaliacao, v.p01_graco as p01_graco, ");
		sb.append("vt.r17_txcoletaagrupada as txColetaAgrupada, vt.r17_txcoletaanalitica as txColetaAnalitica, ");
		sb.append("v.p01_nmverificador,vt.r17_cdnivel1, vt.r17_cdnivel2, vt.r17_cdnivel3, vt.r17_cdnivel4 ");
		sb.append("from r17_verificador_template_m vt join ");
		sb.append("p01_verificador_m v on vt.r17_cdverificador = v.p01_cdverificador ");
		sb.append("join d20_nivel_avaliacao na on v.p01_cdnivelavaliacao = na.d20_cdnivelavaliacao  ");
		sb.append("where vt.r17_cdtemplate =:cdTemplate  ");
		 
		if(ordCatAva) {
			LOGGER.info("ORDENACAO POR CODIGO ALFANUMERICO DO VERIFICADOR");
			sb.append("ORDER BY v.p01_codalfa");
		}
		
		if(ordHierarquica) {
			LOGGER.info("ORDENACAO HIERARQUICA");
			sb.append("ORDER BY vt.r17_cdnivel1,vt.r17_cdnivel2,vt.r17_cdnivel3,vt.r17_cdnivel4");
		}
		
		Query q = manager.createNativeQuery(sb.toString());
		q.setParameter("cdTemplate", cdTemplate);
		
		List<TodosOsVerificadores> verificadores = new ArrayList<TodosOsVerificadores>();

		List<Object[]> list = q.getResultList();  
		if(list  != null){
		  for(Object[] objectArray : list ){
			  BigDecimal codalfa;
			  codalfa = (BigDecimal) objectArray[3];
			  TodosOsVerificadores verificador = new TodosOsVerificadores(
					  (String)objectArray[1], 
					  (String)objectArray[2], 
					  codalfa,			
					  (String)objectArray[4], 
					  (String)objectArray[5], 
					  (String)objectArray[6]);
			  verificadores.add(verificador);
		  }
		}
		return verificadores;  	
	}
	
	@SuppressWarnings("unchecked")
	public List<RelatorioAnaliticoDTO> listaParaRelatorioAnalitico(Long cdavaliacao, boolean ordCatAva, boolean ordHierarquica){
		
		LOGGER.info("BUSCANDO VERIFICADORES PARA MONTAGEM DO RELATORIO ANALITICO");
				
		StringBuilder sb = new StringBuilder();
		sb.append("select d24_nmempresa, d18_nmmonitoramento, d19_nmavaliacao, d19_dtinicio, ");
		sb.append("d19_dtfim, p01_codalfa, p01_nmverificador, p21_nrconf, p21_nrnaoconf, ");
		sb.append("p21_nrobservacoes, p21_graco, p21_resultado ");
		sb.append("from v_verificadores_rel_analitico where p21_cdavaliacao= :cdavaliacao  ");
		 
		/*if(ordCatAva) {
			LOGGER.info("ORDENACAO POR CODIGO ALFANUMERICO DO VERIFICADOR");
			sb.append("ORDER BY v.p01_codalfa");
		}
		
		if(ordHierarquica) {
			LOGGER.info("ORDENACAO HIERARQUICA");
			sb.append("ORDER BY vt.r17_cdnivel1,vt.r17_cdnivel2,vt.r17_cdnivel3,vt.r17_cdnivel4");
		}*/
		
		Query q = manager.createNativeQuery(sb.toString());
		q.setParameter("cdavaliacao", cdavaliacao);
		
		List<RelatorioAnaliticoDTO> relatorioAnalitico = new ArrayList<RelatorioAnaliticoDTO>();

		List<Object[]> list = q.getResultList();  
		if(list  != null){
			
			for(Object[] objectArray : list ){
				RelatorioAnaliticoDTO verificador = new RelatorioAnaliticoDTO( 
					  (String)objectArray[0], 
					  (String)objectArray[1], 
					  (String)objectArray[2], 
					  (Date)objectArray[3],
					  (Date)objectArray[4],
					  (String)objectArray[5],
					  (String)objectArray[6],
			  		  (Integer)objectArray[7],
			  		  (Integer)objectArray[8],
			  		  (Integer)objectArray[9],
			  		  (Integer)objectArray[10],
			  	      (String)objectArray[11]);
			  relatorioAnalitico.add(verificador);
		  }
		}
		return relatorioAnalitico;  	
	}
	
	
	public List<TodosOsVerificadores> todosVerificadores(Long cdTemplate) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<TodosOsVerificadores> criteriaQuery = criteriaBuilder.
				createQuery(TodosOsVerificadores.class);
		
		Root<ModVerificadoresMonitoramentoTemplate> root = criteriaQuery.from(ModVerificadoresMonitoramentoTemplate.class);
		
		criteriaQuery.select(criteriaBuilder.construct(TodosOsVerificadores.class, 
				root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.codalfa),
				root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.cadNivelDeAvaliacao).get(CadNivelDeAvaliacao_.nmNivelDeAvaliacao),
				root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.p01_graco),
				root.get(ModVerificadoresMonitoramentoTemplate_.txColetaAgrupada),
				root.get(ModVerificadoresMonitoramentoTemplate_.txColetaAnalitica),
				root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.nmverificador)
				)).distinct(true);
		
		criteriaQuery.where(
				criteriaBuilder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdTemplate), 
						cdTemplate),
				criteriaBuilder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdEmpresa), 
						cdTemplate));
	
		TypedQuery<TodosOsVerificadores> typedQuery = manager
				.createQuery(criteriaQuery);
		
		return typedQuery.getResultList();
	}
	
	@Override
	public Page<ModVerificadoresMonitoramentoTemplate> filtrar(ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ModVerificadoresMonitoramentoTemplate> criteria = builder .createQuery(ModVerificadoresMonitoramentoTemplate.class);
		Root<ModVerificadoresMonitoramentoTemplate> root = criteria.from(ModVerificadoresMonitoramentoTemplate.class);
		
		Predicate[] predicates = criarRestricoes(modVerificadoresMonitoramentoTemplateFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ModVerificadoresMonitoramentoTemplate> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(modVerificadoresMonitoramentoTemplateFilter));
	}
	

	
	
	public 	Page<ResumoVerificadoresMonitoramentoTemplate> resumir(
			ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter, Pageable pageable) {
		CriteriaBuilder builder = manager .getCriteriaBuilder();
		CriteriaQuery<ResumoVerificadoresMonitoramentoTemplate> criteria = builder.createQuery(ResumoVerificadoresMonitoramentoTemplate.class);
		Root<ModVerificadoresMonitoramentoTemplate> root = criteria.from(ModVerificadoresMonitoramentoTemplate.class);
	
		criteria.select(builder.construct(ResumoVerificadoresMonitoramentoTemplate.class
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdVeriMod)
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.cdTipoDeVerificador).get(CadTipoDeVerificador_.cdTipoDeVerificador)
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdTemplate).get(ModMonitoramentoTemplate_.cdTemplate)
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.cdVerificador)
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.codalfa)
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.cadNivelDeAvaliacao).get(CadNivelDeAvaliacao_.sigla)
				, root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.nmverificador)
				)).distinct(true);
		 
		
		Predicate[] predicates = criarRestricoes(modVerificadoresMonitoramentoTemplateFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoVerificadoresMonitoramentoTemplate> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(modVerificadoresMonitoramentoTemplateFilter));
	}
	
	
	
	

	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = 1000;//pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}
	
	private Predicate[] criarRestricoes(ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter, CriteriaBuilder builder,
			Root<ModVerificadoresMonitoramentoTemplate> root) {
		List<Predicate> predicates = new ArrayList<>();
		if (modVerificadoresMonitoramentoTemplateFilter.getCdTemplate() != null) {
			predicates.add(
					builder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdTemplate).get(ModMonitoramentoTemplate_.cdTemplate), modVerificadoresMonitoramentoTemplateFilter.getCdTemplate()));
		}
		
		if (modVerificadoresMonitoramentoTemplateFilter.getCdTipoDeVerificador() != null) {
			predicates.add(
					builder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.cdTipoDeVerificador).get(CadTipoDeVerificador_.cdTipoDeVerificador), modVerificadoresMonitoramentoTemplateFilter.getCdTipoDeVerificador()));
		}
		
		if (modVerificadoresMonitoramentoTemplateFilter.getCdEmpresa() != null) {
			predicates.add(
					builder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdEmpresa), modVerificadoresMonitoramentoTemplateFilter.getCdEmpresa()));
		}
		
		if (modVerificadoresMonitoramentoTemplateFilter.getCdVerificador() != null) {
			predicates.add(
					builder.equal(root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.codigo), modVerificadoresMonitoramentoTemplateFilter.getCdVerificador()));
		}
		
		if(!StringUtils.isEmpty(modVerificadoresMonitoramentoTemplateFilter.getNmVerificador())) {
			predicates.add(builder.like(
					builder.lower(root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.nmverificador)), "%" + modVerificadoresMonitoramentoTemplateFilter.getNmVerificador().toLowerCase() + "%"));
		};
		
		if(!StringUtils.isEmpty(modVerificadoresMonitoramentoTemplateFilter.getCodalfa())) {
			predicates.add(builder.like(
					builder.lower(root.get(ModVerificadoresMonitoramentoTemplate_.cdVerificador).get(Verificador_m_.codalfa)), "%" + modVerificadoresMonitoramentoTemplateFilter.getCodalfa().toLowerCase() + "%"));
		};
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	

	private Long total(ModVerificadoresMonitoramentoTemplateFilter modVerificadoresMonitoramentoTemplateFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ModVerificadoresMonitoramentoTemplate> root = criteria.from(ModVerificadoresMonitoramentoTemplate.class);
		
		Predicate[] predicates = criarRestricoes(modVerificadoresMonitoramentoTemplateFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	









	


	
	
	

}
