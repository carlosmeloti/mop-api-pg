package br.embrapa.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.embrapa.model.AssociarVerificadorAosLocaisMateriais;
import br.embrapa.repository.filter.AssociarVerificadorAosLocaisMateriaisFilter;

public interface AssociarVerificadorAosLocaisMateriaisRepositoryQuery {
	
	//public Page<AssociarVerificadorAosLocaisMateriais> filtrar(AssociarVerificadorAosLocaisMateriaisFilter associarVerificadorAosLocaisMateriaisFilter, Pageable pageable);
	public Page<AssociarVerificadorAosLocaisMateriais> filtrar(AssociarVerificadorAosLocaisMateriaisFilter associarVerificadorAosLocaisMateriaisFilter, Pageable pageable);
}
