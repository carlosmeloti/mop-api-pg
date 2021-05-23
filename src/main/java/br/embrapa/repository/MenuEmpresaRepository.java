package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.MenuEmpresa;
import br.embrapa.repository.consultas.MenuEmpresaRepositoryQuery;


public interface MenuEmpresaRepository extends JpaRepository<MenuEmpresa, Long>, MenuEmpresaRepositoryQuery {

	
}
