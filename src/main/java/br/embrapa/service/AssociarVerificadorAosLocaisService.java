package br.embrapa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.AssociarVerificadorAosLocais;
import br.embrapa.repository.AssociarVerificadorAosLocaisRepository;

@Service
public class AssociarVerificadorAosLocaisService {
	
	@Autowired
	private AssociarVerificadorAosLocaisRepository associarVerificadorAosLocaisRepository;
	
	
	public AssociarVerificadorAosLocais atualizar(Long codigo, AssociarVerificadorAosLocais associarVerificadorAosLocais) {
		
		AssociarVerificadorAosLocais associarVerificadorAosLocaisSalva = buscarMonitoramentoPeloCodigo(codigo);
		BeanUtils.copyProperties(associarVerificadorAosLocais, associarVerificadorAosLocaisSalva, "codigo");
		return associarVerificadorAosLocaisRepository.save(associarVerificadorAosLocaisSalva);
	}
	
	

	public AssociarVerificadorAosLocais buscarMonitoramentoPeloCodigo(Long codigo) {
		AssociarVerificadorAosLocais associarVerificadorAosLocaisSalva = associarVerificadorAosLocaisRepository.findOne(codigo);
		if (associarVerificadorAosLocaisSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return associarVerificadorAosLocaisSalva;
	}

}
