package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.AssociarVerificadorAosLocais;
import br.embrapa.repository.consultas.AssociarVerificadorAosLocaisRepositoryQuery;

public interface AssociarVerificadorAosLocaisRepository extends JpaRepository<AssociarVerificadorAosLocais, Long>, 
AssociarVerificadorAosLocaisRepositoryQuery {

}
