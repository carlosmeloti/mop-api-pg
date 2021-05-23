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

import br.embrapa.model.AppVerificadoresMonitoramento;
import br.embrapa.model.AppVerificadoresMonitoramento_;
import br.embrapa.repository.filter.AppVerificadoresMonitoramentoFilter;

public class AppVerificadoresMonitoramentoRepositoryImpl implements  AppVerificadoresMonitoramentoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<AppVerificadoresMonitoramento> filtrar(
			AppVerificadoresMonitoramentoFilter appVerificadoresMonitoramentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<AppVerificadoresMonitoramento> criteria = builder .createQuery(AppVerificadoresMonitoramento.class);
		Root<AppVerificadoresMonitoramento> root = criteria.from(AppVerificadoresMonitoramento.class);
		
		Predicate[] predicates = criarRestricoes(appVerificadoresMonitoramentoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<AppVerificadoresMonitoramento> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(),pageable, total(appVerificadoresMonitoramentoFilter));
	}

	private Long total(AppVerificadoresMonitoramentoFilter appVerificadoresMonitoramentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<AppVerificadoresMonitoramento> root = criteria.from(AppVerificadoresMonitoramento.class);
		
		Predicate[] predicates = criarRestricoes(appVerificadoresMonitoramentoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = 1000;
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}

	private Predicate[] criarRestricoes(AppVerificadoresMonitoramentoFilter appVerificadoresMonitoramentoFilter,
			CriteriaBuilder builder, Root<AppVerificadoresMonitoramento> root) {
		List<Predicate> predicates = new ArrayList<>();
		if (appVerificadoresMonitoramentoFilter.getCdMonitoramento() != null) {
			predicates.add(
					builder.equal(root.get(AppVerificadoresMonitoramento_.cdMonitoramento), appVerificadoresMonitoramentoFilter.getCdMonitoramento()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
}
