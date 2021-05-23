package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.AppColetaDeDados;
import br.embrapa.repository.consultas.AppColetaDeDadosRepositoryQuery;

public interface AppColetaDeDadosRepository extends JpaRepository<AppColetaDeDados, Long>, AppColetaDeDadosRepositoryQuery {

}
