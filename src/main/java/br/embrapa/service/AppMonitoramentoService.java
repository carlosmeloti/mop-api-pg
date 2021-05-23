package br.embrapa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.AppMonitoramento;
import br.embrapa.repository.AppMonitoramentoRepository;

@Service
public class AppMonitoramentoService {

	@Autowired
	private AppMonitoramentoRepository appMonitoramentoRepository;
	
	
	public AppMonitoramento atualizar(Long codigo, AppMonitoramento appMonitoramento) {
		
		AppMonitoramento appMonitoramentoSalva = buscarMonitoramentoPeloCodigo(codigo);
		BeanUtils.copyProperties(appMonitoramento, appMonitoramentoSalva, "codigo");
		return appMonitoramentoRepository.save(appMonitoramentoSalva);
	}
	
	

	public AppMonitoramento buscarMonitoramentoPeloCodigo(Long codigo) {
		AppMonitoramento appMonitoramentoSalva = appMonitoramentoRepository.findOne(codigo);
		if (appMonitoramentoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return appMonitoramentoSalva;
	}
}
