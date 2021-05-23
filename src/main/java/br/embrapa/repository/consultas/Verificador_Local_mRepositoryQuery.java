package br.embrapa.repository.consultas;

import java.util.List;

import br.embrapa.model.Verificador_Local_m;
import br.embrapa.repository.filter.Verificador_Local_mFilter;



public interface Verificador_Local_mRepositoryQuery {
	
	public List<Verificador_Local_m> filtrar(Verificador_Local_mFilter verificador_Local_mFilter);

}
