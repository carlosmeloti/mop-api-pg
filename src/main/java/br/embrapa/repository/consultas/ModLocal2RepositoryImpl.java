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

import br.embrapa.model.ModLocal1;
import br.embrapa.model.ModLocal1_;
import br.embrapa.model.ModLocal2;
import br.embrapa.model.ModLocal2_;
import br.embrapa.repository.filter.ModLocal2Filter;
import br.embrapa.repository.projections.ResumoModLocal2;

public class ModLocal2RepositoryImpl {
	
	
	@PersistenceContext
	private EntityManager manager;
	
	public Page<ModLocal2> filtrar(ModLocal2Filter modLocal2Filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ModLocal2> criteria = builder .createQuery(ModLocal2.class);
		Root<ModLocal2> root = criteria.from(ModLocal2.class);
		
		Predicate[] predicates = criarRestricoes(modLocal2Filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ModLocal2> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(modLocal2Filter));
	}


	
	public Page<ResumoModLocal2> resumir(ModLocal2Filter modLocal2Filter, Pageable pageable) {
		CriteriaBuilder builder = manager .getCriteriaBuilder();
		CriteriaQuery<ResumoModLocal2> criteria = builder.createQuery(ResumoModLocal2.class);
		Root<ModLocal2> root = criteria.from(ModLocal2.class);
		
		criteria.select(builder.construct(ResumoModLocal2.class
				/*, root.get(ModLocal2_.cdLocal2)
				, root.get(ModLocal2_.modLocal1).get(ModLocal1_.nmlocal1)*/
				, root.get(ModLocal2_.nmLocal2)));
		
		
		Predicate[] predicates = criarRestricoes(modLocal2Filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoModLocal2> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		
		return new PageImpl<>(query.getResultList(), pageable, total(modLocal2Filter));
	}

	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = 1000;
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}
	
	

	private Long total(ModLocal2Filter modLocal2Filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ModLocal2> root = criteria.from(ModLocal2.class);
		
		Predicate[] predicates = criarRestricoes(modLocal2Filter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


	private Predicate[] criarRestricoes(ModLocal2Filter modLocal2Filter, CriteriaBuilder builder,
			Root<ModLocal2> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (modLocal2Filter.getCdLocal1() != null) {
			predicates.add(
					builder.equal(root.get(ModLocal2_.cdLocal1).get(ModLocal1_.cdLocal1), modLocal2Filter.getCdLocal1()));
		}
		if (modLocal2Filter.getCdEmpresa() != null) {
			predicates.add(
					builder.equal(root.get(ModLocal2_.cdEmpresa), modLocal2Filter.getCdEmpresa()));
		}

		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}