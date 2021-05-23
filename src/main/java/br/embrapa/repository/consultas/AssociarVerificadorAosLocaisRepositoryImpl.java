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

import br.embrapa.model.AssociarVerificadorAosLocais;
import br.embrapa.model.AssociarVerificadorAosLocais_;
import br.embrapa.model.CadEmpresa_;
import br.embrapa.model.AssociarVerificadorAosLocais;
import br.embrapa.repository.filter.AssociarVerificadorAosLocaisFilter;
import br.embrapa.repository.filter.AssociarVerificadorAosLocaisFilter;

public class AssociarVerificadorAosLocaisRepositoryImpl implements AssociarVerificadorAosLocaisRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<AssociarVerificadorAosLocais> filtrar(
			AssociarVerificadorAosLocaisFilter associarVerificadorAosLocaisFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<AssociarVerificadorAosLocais> criteria = builder .createQuery(AssociarVerificadorAosLocais.class);
		Root<AssociarVerificadorAosLocais> root = criteria.from(AssociarVerificadorAosLocais.class);
		
		Predicate[] predicates = criarRestricoes(associarVerificadorAosLocaisFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<AssociarVerificadorAosLocais> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(),pageable, total(associarVerificadorAosLocaisFilter));
	}

	private Long total(AssociarVerificadorAosLocaisFilter associarVerificadorAosLocaisFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<AssociarVerificadorAosLocais> root = criteria.from(AssociarVerificadorAosLocais.class);
		
		Predicate[] predicates = criarRestricoes(associarVerificadorAosLocaisFilter, builder, root);
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

	private Predicate[] criarRestricoes(AssociarVerificadorAosLocaisFilter associarVerificadorAosLocaisFilter,
			CriteriaBuilder builder, Root<AssociarVerificadorAosLocais> root) {
		List<Predicate> predicates = new ArrayList<>();
		if (associarVerificadorAosLocaisFilter.getIdVerificador() != null) {
			predicates.add(
					builder.equal(root.get(AssociarVerificadorAosLocais_.idVerificador), associarVerificadorAosLocaisFilter.getIdVerificador()));
		}
		if (associarVerificadorAosLocaisFilter.getCdEmpresa() != null) {
			predicates.add(
					builder.equal(root.get(AssociarVerificadorAosLocais_.cdEmpresa).get(CadEmpresa_.cdEmpresa), associarVerificadorAosLocaisFilter.getCdEmpresa()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	

}
