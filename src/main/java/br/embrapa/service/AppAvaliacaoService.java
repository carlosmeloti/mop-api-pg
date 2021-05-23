package br.embrapa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.AppAvaliacao;
import br.embrapa.repository.AppAvaliacaoRepository;

@Service
public class AppAvaliacaoService {

	@Autowired
	private AppAvaliacaoRepository appAvaliacaoRepository;
	
	
	public AppAvaliacao atualizar(Long codigo, AppAvaliacao appAvaliacao) {
		
		AppAvaliacao appAvaliacaoSalva = buscarMonitoramentoPeloCodigo(codigo);
		BeanUtils.copyProperties(appAvaliacao, appAvaliacaoSalva, "codigo");
		return appAvaliacaoRepository.save(appAvaliacaoSalva);
	}
	
	

	public AppAvaliacao buscarMonitoramentoPeloCodigo(Long codigo) {
		AppAvaliacao appAvaliacaoSalva = appAvaliacaoRepository.findOne(codigo);
		if (appAvaliacaoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return appAvaliacaoSalva;
	}
	
}
