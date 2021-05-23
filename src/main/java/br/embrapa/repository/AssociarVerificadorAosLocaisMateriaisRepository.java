package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.AssociarVerificadorAosLocaisMateriais;
import br.embrapa.repository.consultas.AssociarVerificadorAosLocaisMateriaisRepositoryQuery;

public interface AssociarVerificadorAosLocaisMateriaisRepository extends JpaRepository<AssociarVerificadorAosLocaisMateriais, Long>,
AssociarVerificadorAosLocaisMateriaisRepositoryQuery{

}
 