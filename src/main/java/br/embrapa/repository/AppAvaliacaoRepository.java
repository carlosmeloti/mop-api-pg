package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.AppAvaliacao;
import br.embrapa.repository.consultas.AppAvaliacaoRepositoryQuery;

public interface AppAvaliacaoRepository extends JpaRepository<AppAvaliacao, Long>, AppAvaliacaoRepositoryQuery{

	
	
}
