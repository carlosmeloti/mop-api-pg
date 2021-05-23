package br.embrapa.repository.consultas;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.embrapa.model.MenuEmpresa;
import br.embrapa.repository.filter.MenuEmpresaFilter;

public interface MenuEmpresaRepositoryQuery {
	
	public Page<MenuEmpresa> filtrar(MenuEmpresaFilter menuEmpresaFilter, Pageable pageable);

	
	//List<MenuEmpresa> recuperarEmpresSelecionada();
	



}
