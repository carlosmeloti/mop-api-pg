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

import br.embrapa.model.AppAvaliacao_;
import br.embrapa.model.AppColetaDeDados;
import br.embrapa.model.AppColetaDeDados_;
import br.embrapa.model.AppMonitoramento_;
import br.embrapa.repository.filter.AppColetaDeDadosFilter;

public class AppColetaDeDadosRepositoryImpl implements AppColetaDeDadosRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<AppColetaDeDados> filtrar(AppColetaDeDadosFilter appColetaDeDadosFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<AppColetaDeDados> criteria = builder .createQuery(AppColetaDeDados.class);
		Root<AppColetaDeDados> root = criteria.from(AppColetaDeDados.class);
		
		Predicate[] predicates = criarRestricoes(appColetaDeDadosFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<AppColetaDeDados> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(appColetaDeDadosFilter));
	}


	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = 1000;
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}


	private Long total(AppColetaDeDadosFilter appColetaDeDadosFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<AppColetaDeDados> root = criteria.from(AppColetaDeDados.class);
		
		Predicate[] predicates = criarRestricoes(appColetaDeDadosFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


	private Predicate[] criarRestricoes(AppColetaDeDadosFilter appColetaDeDadosFilter, CriteriaBuilder builder,
			Root<AppColetaDeDados> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (appColetaDeDadosFilter.getCdMonitoramento() != null) {
			predicates.add(
					builder.equal(root.get(AppColetaDeDados_.cdMonitoramento).get(AppMonitoramento_.cdMonitoramento), appColetaDeDadosFilter.getCdMonitoramento()));
		}
		if (appColetaDeDadosFilter.getCdAvaliacao() != null) {
			predicates.add(
					builder.equal(root.get(AppColetaDeDados_.cdAvaliacao).get(AppAvaliacao_.cdAvaliacao), appColetaDeDadosFilter.getCdAvaliacao()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}


	
	


}
