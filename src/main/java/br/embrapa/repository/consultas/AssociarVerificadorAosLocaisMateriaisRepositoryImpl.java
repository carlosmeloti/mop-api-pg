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

import br.embrapa.model.AssociarVerificadorAosLocaisMateriais;
import br.embrapa.model.AssociarVerificadorAosLocaisMateriais_;
import br.embrapa.model.AssociarVerificadorAosLocais_;
import br.embrapa.repository.filter.AssociarVerificadorAosLocaisMateriaisFilter;

public class AssociarVerificadorAosLocaisMateriaisRepositoryImpl implements AssociarVerificadorAosLocaisMateriaisRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	public Page<AssociarVerificadorAosLocaisMateriais> filtrar(
			AssociarVerificadorAosLocaisMateriaisFilter associarVerificadorAosLocaisMateriaisFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<AssociarVerificadorAosLocaisMateriais> criteria = builder .createQuery(AssociarVerificadorAosLocaisMateriais.class);
		Root<AssociarVerificadorAosLocaisMateriais> root = criteria.from(AssociarVerificadorAosLocaisMateriais.class);
		
		Predicate[] predicates = criarRestricoes(associarVerificadorAosLocaisMateriaisFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<AssociarVerificadorAosLocaisMateriais> query = manager.createQuery(criteria);
		adiconarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(),pageable, total(associarVerificadorAosLocaisMateriaisFilter));
	}

	private Long total(AssociarVerificadorAosLocaisMateriaisFilter associarVerificadorAosLocaisMateriaisFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<AssociarVerificadorAosLocaisMateriais> root = criteria.from(AssociarVerificadorAosLocaisMateriais.class);
		
		Predicate[] predicates = criarRestricoes(associarVerificadorAosLocaisMateriaisFilter, builder, root);
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

	private Predicate[] criarRestricoes(AssociarVerificadorAosLocaisMateriaisFilter associarVerificadorAosLocaisMateriaisFilter,
			CriteriaBuilder builder, Root<AssociarVerificadorAosLocaisMateriais> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (associarVerificadorAosLocaisMateriaisFilter.getId_material() != null) {
			predicates.add(
					builder.equal(root.get(AssociarVerificadorAosLocaisMateriais_.id_material), associarVerificadorAosLocaisMateriaisFilter.getId_material()));
		}
		
		if (associarVerificadorAosLocaisMateriaisFilter.getId_verificador_local() != null) {
			predicates.add(
					builder.equal(root.get(AssociarVerificadorAosLocaisMateriais_.id_verificador_local).get(AssociarVerificadorAosLocais_.id), associarVerificadorAosLocaisMateriaisFilter.getId_verificador_local	()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	
	
}
