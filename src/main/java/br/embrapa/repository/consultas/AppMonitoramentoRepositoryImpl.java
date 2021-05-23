package br.embrapa.repository.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.embrapa.model.AppMonitoramento;
import br.embrapa.model.AppMonitoramento_;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate_;
import br.embrapa.repository.filter.AppMonitoramentoFilter;


public class AppMonitoramentoRepositoryImpl implements AppMonitoramentoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<AppMonitoramento> filtrar(AppMonitoramentoFilter appMonitoramentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<AppMonitoramento> criteria = builder .createQuery(AppMonitoramento.class);
		Root<AppMonitoramento> root = criteria.from(AppMonitoramento.class);
		
		Predicate[] predicates = criarRestricoes(appMonitoramentoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<AppMonitoramento> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(appMonitoramentoFilter));
	}
	
	/*@Override
	public Page<ResumoCadAmostragem> resumir(CadAmostragemFilter cadAmostragemFilter, Pageable pageable) {
		CriteriaBuilder builder = manager .getCriteriaBuilder();
		CriteriaQuery<ResumoCadAmostragem> criteria = builder.createQuery(ResumoCadAmostragem.class);
		Root<CadAmostragem> root = criteria.from(CadAmostragem.class);
		
		criteria.select(builder.construct(ResumoCadAmostragem.class
				, root.get(CadAmostragem_.cdAmostragem)
				, root.get(CadAmostragem_.nmAmostragem)));
		
		
		Predicate[] predicates = criarRestricoes(cadAmostragemFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoCadAmostragem> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		
		return new PageImpl<>(query.getResultList(), pageable, total(cadAmostragemFilter));
	}*/
	


	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = 1000;
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
	}
	
	private Long total(AppMonitoramentoFilter appMonitoramentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<AppMonitoramento> root = criteria.from(AppMonitoramento.class);
		
		Predicate[] predicates = criarRestricoes(appMonitoramentoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private Predicate[] criarRestricoes(AppMonitoramentoFilter appMonitoramentoFilter, CriteriaBuilder builder,
			Root<AppMonitoramento> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(appMonitoramentoFilter.getNmMonitoramento())) {
			predicates.add(builder.like(
					builder.lower(root.get(AppMonitoramento_.nmMonitoramento)), "%" + appMonitoramentoFilter.getNmMonitoramento().toLowerCase() + "%"));
		}
		if (appMonitoramentoFilter.getCdTemplate() != null) {
			predicates.add(
					builder.equal(root.get(AppMonitoramento_.cdTemplate), appMonitoramentoFilter.getCdTemplate()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
}
