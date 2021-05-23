package br.embrapa.repository.consultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.embrapa.model.AssociarVerificadorAosLocais;
import br.embrapa.repository.filter.AssociarVerificadorAosLocaisFilter;


public interface AssociarVerificadorAosLocaisRepositoryQuery {
	
	public Page<AssociarVerificadorAosLocais> filtrar(AssociarVerificadorAosLocaisFilter associarVerificadorAosLocaisFilter, Pageable pageable);

}
