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

import br.embrapa.model.CadMaterial_;
import br.embrapa.model.ModLocal1;
import br.embrapa.model.ModLocal1_;
import br.embrapa.repository.filter.ModLocal1Filter;
import br.embrapa.repository.projections.ResumoModLocal1;


public class ModLocal1RepositoryImpl {

	@PersistenceContext
	private EntityManager manager;
	
	/*public ModLocal1 buscarPorChaveComposta(ModLocal1_PK pk) {
		return manager.find(ModLocal1.class, pk);
	}*/
	
	
	public Page<ModLocal1> filtrar(ModLocal1Filter modLocal1Filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ModLocal1> criteria = builder .createQuery(ModLocal1.class);
		Root<ModLocal1> root = criteria.from(ModLocal1.class);
		
		Predicate[] predicates = criarRestricoes(modLocal1Filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ModLocal1> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(modLocal1Filter));
	}



	
	public Page<ResumoModLocal1> resumir(ModLocal1Filter modLocal1Filter, Pageable pageable) {
		CriteriaBuilder builder = manager .getCriteriaBuilder();
		CriteriaQuery<ResumoModLocal1> criteria = builder.createQuery(ResumoModLocal1.class);
		Root<ModLocal1> root = criteria.from(ModLocal1.class);
		
		criteria.select(builder.construct(ResumoModLocal1.class
				, root.get(ModLocal1_.cdLocal1)
				, root.get(ModLocal1_.nmlocal1)));
		
		
		Predicate[] predicates = criarRestricoes(modLocal1Filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoModLocal1> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		
		return new PageImpl<>(query.getResultList(), pageable, total(modLocal1Filter));
	}

	private void adiconarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistrosPorPagina = 1000;
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistrosPorPagina);
		
	}
	
	

	private Long total(ModLocal1Filter modLocal1Filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ModLocal1> root = criteria.from(ModLocal1.class);
		
		Predicate[] predicates = criarRestricoes(modLocal1Filter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


	private Predicate[] criarRestricoes(ModLocal1Filter modLocal1Filter, CriteriaBuilder builder,
			Root<ModLocal1> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(modLocal1Filter.getNmlocal1())) {
			predicates.add(builder.like(
					builder.lower(root.get(ModLocal1_.nmlocal1)), "%" + modLocal1Filter.getNmlocal1().toLowerCase() + "%"));
		}
		if (modLocal1Filter.getCdEmpresa() != null) {
			predicates.add(
					builder.equal(root.get(ModLocal1_.cdEmpresa), modLocal1Filter.getCdEmpresa()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	
	

	
	
}
