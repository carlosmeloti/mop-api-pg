package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.Verificador_Local_m;
import br.embrapa.repository.consultas.Verificador_Local_mRepositoryQuery;

public interface Verificador_Local_mRepository extends JpaRepository<Verificador_Local_m, Long>, Verificador_Local_mRepositoryQuery{

}
