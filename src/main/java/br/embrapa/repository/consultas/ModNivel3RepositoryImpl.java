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

import br.embrapa.model.ModNivel1_;
import br.embrapa.model.ModNivel2_;
import br.embrapa.model.ModNivel3;
import br.embrapa.model.ModNivel3_;
import br.embrapa.repository.filter.ModNivel3Filter;
import br.embrapa.repository.projections.ResumoModNivel3;



public class ModNivel3RepositoryImpl {
	
	
	@PersistenceContext
	private EntityManager manager; 
	
	
	public Page<ModNivel3> filtrar(ModNivel3Filter modNivel3Filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ModNivel3> criteria = builder .createQuery(ModNivel3.class);
		Root<ModNivel3> root = criteria.from(ModNivel3.class);
		
		Predicate[] predicates = criarRestricoes(modNivel3Filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ModNivel3> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(modNivel3Filter));
	}
	
	
	public Page<ResumoModNivel3> resumir(ModNivel3Filter modNivel3Filter, Pageable pageable) {
		CriteriaBuilder builder = manager .getCriteriaBuilder();
		CriteriaQuery<ResumoModNivel3> criteria = builder.createQuery(ResumoModNivel3.class);
		Root<ModNivel3> root = criteria.from(ModNivel3.class);
		
		criteria.select(builder.construct(ResumoModNivel3.class
			/*	, root.get(ModNivel3_.cdNivel1).get(ModNivel1_.nmNivel1)
				, root.get(ModNivel3_.cdNivel2).get(ModNivel2_.nmNivel2)
				, root.get(ModNivel3_.cdNivel3)*/
				, root.get(ModNivel3_.nmNivel3)));
		
		
		Predicate[] predicates = criarRestricoes(modNivel3Filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoModNivel3> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		
		return new PageImpl<>(query.getResultList(), pageable, total(modNivel3Filter));
	}

	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = 1000;
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}

	private Long total(ModNivel3Filter modNivel3Filter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ModNivel3> root = criteria.from(ModNivel3.class);
		
		Predicate[] predicates = criarRestricoes(modNivel3Filter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


	private Predicate[] criarRestricoes(ModNivel3Filter modNivel3Filter, CriteriaBuilder builder,
			Root<ModNivel3> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (modNivel3Filter.getCdNivel1() != null) {
			predicates.add(
			builder.equal(root.get(ModNivel3_.cdNivel1).get(ModNivel1_.cdNivel1), modNivel3Filter.getCdNivel1()));
		}
		
		if (modNivel3Filter.getCdNivel2() != null) {
			predicates.add(
			builder.equal(root.get(ModNivel3_.cdNivel2).get(ModNivel2_.cdNivel2), modNivel3Filter.getCdNivel2()));
		}
		if (modNivel3Filter.getCdEmpresa() != null) {
			predicates.add(
					builder.equal(root.get(ModNivel3_.cdEmpresa), modNivel3Filter.getCdEmpresa()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
