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

import br.embrapa.model.AppAvaliacao;
import br.embrapa.model.AppAvaliacao_;
import br.embrapa.model.AppMonitoramento_;
import br.embrapa.model.CadAmostragem_;
import br.embrapa.repository.filter.AppAvaliacaoFilter;

public class AppAvaliacaoRepositoryImpl implements AppAvaliacaoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public Page<AppAvaliacao> filtrar(AppAvaliacaoFilter appAvaliacaoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<AppAvaliacao> criteria = builder .createQuery(AppAvaliacao.class);
		Root<AppAvaliacao> root = criteria.from(AppAvaliacao.class);
		
		Predicate[] predicates = criarRestricoes(appAvaliacaoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<AppAvaliacao> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(appAvaliacaoFilter));
	}


	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = 1000;
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}


	private Long total(AppAvaliacaoFilter appAvaliacaoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<AppAvaliacao> root = criteria.from(AppAvaliacao.class);
		
		Predicate[] predicates = criarRestricoes(appAvaliacaoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


	private Predicate[] criarRestricoes(AppAvaliacaoFilter appAvaliacaoFilter, CriteriaBuilder builder,
			Root<AppAvaliacao> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(appAvaliacaoFilter.getNmAvaliacao())) {
			predicates.add(builder.like(
					builder.lower(root.get(AppAvaliacao_.nmAvaliacao)), "%" + appAvaliacaoFilter.getNmAvaliacao().toLowerCase() + "%"));
		}
		if(!StringUtils.isEmpty(appAvaliacaoFilter.getNmMonitoramento())) {
			predicates.add(builder.like(
					builder.lower(root.get(AppAvaliacao_.cdMonitoramento).get(AppMonitoramento_.nmMonitoramento)), "%" + appAvaliacaoFilter.getNmMonitoramento().toLowerCase() + "%"));
		}
		if (appAvaliacaoFilter.getCdMonitoramento() != null) {
			predicates.add(
					builder.equal(root.get(AppAvaliacao_.cdMonitoramento), appAvaliacaoFilter.getCdMonitoramento()));
		}
		if (appAvaliacaoFilter.getCdEmpresa() != null) {
			predicates.add(
					builder.equal(root.get(AppAvaliacao_.cdEmpresa), appAvaliacaoFilter.getCdEmpresa()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}


	
	

	

}
