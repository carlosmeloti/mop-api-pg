package br.embrapa.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.embrapa.model.AppColetaDeDados;
import br.embrapa.repository.filter.AppColetaDeDadosFilter;


public interface AppColetaDeDadosRepositoryQuery {

	public Page<AppColetaDeDados> filtrar(AppColetaDeDadosFilter appColetaDeDadosFilter, Pageable pageable);
}
