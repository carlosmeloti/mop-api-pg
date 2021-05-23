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

import br.embrapa.model.ModLocal1_;
import br.embrapa.model.ModLocal2_;
import br.embrapa.model.ModLocal3;
import br.embrapa.model.ModLocal3_;
import br.embrapa.repository.filter.ModLocal3Filter;
import br.embrapa.repository.projections.ResumoModLocal3;


public class ModLocal3RepositoryImpl {
	
	@PersistenceContext
	private EntityManager manager;
	
	public Page<ModLocal3> filtrar(ModLocal3Filter modLocal3Filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ModLocal3> criteria = builder .createQuery(ModLocal3.class);
		Root<ModLocal3> root = criteria.from(ModLocal3.class);
		
		Predicate[] predicates = criarRestricoes(modLocal3Filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ModLocal3> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(modLocal3Filter));
	}
	
	public Page<ResumoModLocal3> resumir(ModLocal3Filter modLocal3Filter, Pageable pageable) {
		CriteriaBuilder builder = manager .getCriteriaBuilder();
		CriteriaQuery<ResumoModLocal3> criteria = builder.createQuery(ResumoModLocal3.class);
		Root<ModLocal3> root = criteria.from(ModLocal3.class);
		
		criteria.select(builder.construct(ResumoModLocal3.class
				, root.get(ModLocal3_.cdLocal3)
			//	, root.get(ModLocal3_.pkLocal3).get(ModLocal2_PK_.nmLocal2)
				// root.get(ModLocal3_.modLocal2).get(ModLocal2_.modLocal1).get(ModLocal1_.nmlocal1)
				, root.get(ModLocal3_.nmLocal3)));
		
		
		Predicate[] predicates = criarRestricoes(modLocal3Filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoModLocal3> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		
		return new PageImpl<>(query.getResultList(), pageable, total(modLocal3Filter));
	}

	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = 1000;
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}
	

	private Long total(ModLocal3Filter modLocal3Filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ModLocal3> root = criteria.from(ModLocal3.class);
		
		Predicate[] predicates = criarRestricoes(modLocal3Filter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


	private Predicate[] criarRestricoes(ModLocal3Filter modLocal3Filter, CriteriaBuilder builder,
			Root<ModLocal3> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (modLocal3Filter.getCdLocal1() != null) {
			predicates.add(
					builder.equal(root.get(ModLocal3_.cdLocal2).get(ModLocal2_.cdLocal1).get(ModLocal1_.cdLocal1), modLocal3Filter.getCdLocal1()));
}
		if (modLocal3Filter.getCdLocal2() != null) {
			predicates.add(
					builder.equal(root.get(ModLocal3_.cdLocal2).get(ModLocal2_.cdLocal2), modLocal3Filter.getCdLocal2()));
}
		if (modLocal3Filter.getCdEmpresa() != null) {
			predicates.add(
					builder.equal(root.get(ModLocal3_.cdEmpresa), modLocal3Filter.getCdEmpresa()));
		}
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	
}