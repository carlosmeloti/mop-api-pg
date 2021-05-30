package br.embrapa.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import br.embrapa.dto.TodosOsVerificadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.ModVerificadoresMonitoramentoTemplate;
import br.embrapa.repository.ModVerificadoresMonitoramentoTemplateRepository;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ModVerificadoresMonitoramentoTemplateService {

	@Autowired
	private ModVerificadoresMonitoramentoTemplateRepository modVerificadoresMonitoramentoTemplateRepository;
	
	public byte[] todosVerificadores(Long cdTemplate) throws Exception {
		List<TodosOsVerificadores> dados = modVerificadoresMonitoramentoTemplateRepository.listaVerificadores(cdTemplate);
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("cdTemplate", Long.valueOf(cdTemplate));
		//parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		InputStream inputStream = this.getClass().getResourceAsStream(
				"/relatorios/formtodososverificadores.jasper");
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,
				new JRBeanCollectionDataSource(dados));
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}
	
	public ModVerificadoresMonitoramentoTemplate atualizar(Long codigo, ModVerificadoresMonitoramentoTemplate modVerificadoresMonitoramentoTemplate) {
		
		ModVerificadoresMonitoramentoTemplate modVerificadoresMonitoramentoTemplateSalva = buscarVerificadorPeloCodigo(codigo);
		BeanUtils.copyProperties(modVerificadoresMonitoramentoTemplate, modVerificadoresMonitoramentoTemplateSalva, "codigo");
		return modVerificadoresMonitoramentoTemplateRepository.save(modVerificadoresMonitoramentoTemplateSalva);
	}
	

	public ModVerificadoresMonitoramentoTemplate buscarVerificadorPeloCodigo(Long codigo) {
		ModVerificadoresMonitoramentoTemplate modVerificadoresMonitoramentoTemplateSalva = modVerificadoresMonitoramentoTemplateRepository.findOne(codigo);
		if (modVerificadoresMonitoramentoTemplateSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return modVerificadoresMonitoramentoTemplateSalva;
	}
	
}
