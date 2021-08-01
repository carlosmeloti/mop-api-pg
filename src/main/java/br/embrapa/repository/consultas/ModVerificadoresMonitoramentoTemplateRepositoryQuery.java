package br.embrapa.repository.consultas;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.embrapa.dto.TodosOsVerificadores;
import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.filter.CadFrequenciaFilter;
import br.embrapa.repository.filter.ModVerificadoresMonitoramentoTemplateFilter;
import br.embrapa.repository.projections.CountVerificadores;
import br.embrapa.repository.projections.ResumoVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.projections.ResumoVerificadoresMonitoramentoTemplateTeste;

public interface ModVerificadoresMonitoramentoTemplateRepositoryQuery {
	
	public List<TodosOsVerificadores> listaVerificadores(Long cdTemplate, boolean ordCatAva, boolean ordHierarquica);

	public List<TodosOsVerificadores> todosVerificadores(Long cdTemplate);
	
	public Page<ModVerificadoresMonitoramentoTemplate> filtrar(ModVerificadoresMonitoramentoTemplateFilter 
			modVerificadoresMonitoramentoTemplateFilter, Pageable pageable);
	
	public Page<ResumoVerificadoresMonitoramentoTemplate> resumir(ModVerificadoresMonitoramentoTemplateFilter 
				modVerificadoresMonitoramentoTemplateFilter, Pageable pageable);
	
	
}
