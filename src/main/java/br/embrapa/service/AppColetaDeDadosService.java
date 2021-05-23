package br.embrapa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.AppColetaDeDados;
import br.embrapa.repository.AppColetaDeDadosRepository;


@Service
public class AppColetaDeDadosService {
	
	@Autowired
	private AppColetaDeDadosRepository appColetaDeDadosRepository;
	
	
	public AppColetaDeDados atualizar(Long codigo, AppColetaDeDados appColetaDeDados) {
		
		AppColetaDeDados appColetaDeDadosSalva = buscarMonitoramentoPeloCodigo(codigo);
		BeanUtils.copyProperties(appColetaDeDados, appColetaDeDadosSalva, "codigo");
		return appColetaDeDadosRepository.save(appColetaDeDadosSalva);
	}
	
	

	public AppColetaDeDados buscarMonitoramentoPeloCodigo(Long codigo) {
		AppColetaDeDados appColetaDeDadosSalva = appColetaDeDadosRepository.findOne(codigo);
		if (appColetaDeDadosSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return appColetaDeDadosSalva;
	}
	

}
