package br.embrapa.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.embrapa.model.AppAvaliacao;
import br.embrapa.repository.filter.AppAvaliacaoFilter;



public interface AppAvaliacaoRepositoryQuery {
	
	public Page<AppAvaliacao> filtrar(AppAvaliacaoFilter appAvaliacaoFilter, Pageable pageable);

}
