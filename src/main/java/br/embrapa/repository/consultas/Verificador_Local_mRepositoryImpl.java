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

import org.springframework.util.StringUtils;

import br.embrapa.model.Verificador_Local_m;
import br.embrapa.model.Verificador_Local_m_;
import br.embrapa.model.Verificador_m_;
import br.embrapa.repository.filter.Verificador_Local_mFilter;

public class Verificador_Local_mRepositoryImpl implements Verificador_Local_mRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Verificador_Local_m> filtrar(Verificador_Local_mFilter verificador_Local_mFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Verificador_Local_m> criteria = builder .createQuery(Verificador_Local_m.class);
		Root<Verificador_Local_m> root = criteria.from(Verificador_Local_m.class);
		
		Predicate[] predicates = criarRestricoes(verificador_Local_mFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Verificador_Local_m> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(Verificador_Local_mFilter verificador_Local_mFilter, CriteriaBuilder builder,
			Root<Verificador_Local_m> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(verificador_Local_mFilter.getCodigo())) {
			predicates.add(builder.like(
				builder.lower(root.get(Verificador_Local_m_.codigoVerificadorLocal).get(Verificador_m_.nmverificador)), "%" + verificador_Local_mFilter.getNmVerificador().toLowerCase() + "%"));
		}
		
		if (verificador_Local_mFilter.getCodigo() != null) {
			predicates.add(
					builder.equal(root.get(Verificador_Local_m_.codigoVerificadorLocal), verificador_Local_mFilter.getCodigo()));
		}
		/*if (verificador_Local_mFilter.getCdTipoDeVerificador() != null) {
			predicates.add(
					builder.equal(root.get(Verificador_m_.cdVerificador), verificador_mFilter.getCdVerificador()));
		}
		if (verificador_Local_mFilter.getCodigo() != null) {
			predicates.add(
					builder.equal(root.get(Verificador_m_.codigo), verificador_mFilter.getCodigo()));
		}*/
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	}

