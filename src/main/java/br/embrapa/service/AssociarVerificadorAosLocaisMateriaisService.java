package br.embrapa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.AssociarVerificadorAosLocaisMateriais;
import br.embrapa.repository.AssociarVerificadorAosLocaisMateriaisRepository;

@Service
public class AssociarVerificadorAosLocaisMateriaisService {
	
	@Autowired
	private AssociarVerificadorAosLocaisMateriaisRepository associarVerificadorAosLocaisMateriaisRepository;
	
	
	public AssociarVerificadorAosLocaisMateriais atualizar(Long codigo, AssociarVerificadorAosLocaisMateriais associarVerificadorAosLocaisMateriais) {
		
		AssociarVerificadorAosLocaisMateriais associarVerificadorAosLocaisMateriaisSalva = buscarMonitoramentoPeloCodigo(codigo);
		BeanUtils.copyProperties(associarVerificadorAosLocaisMateriais, associarVerificadorAosLocaisMateriaisSalva, "codigo");
		return associarVerificadorAosLocaisMateriaisRepository.save(associarVerificadorAosLocaisMateriaisSalva);
	}
	
	

	public AssociarVerificadorAosLocaisMateriais buscarMonitoramentoPeloCodigo(Long codigo) {
		AssociarVerificadorAosLocaisMateriais associarVerificadorAosLocaisMateriaisSalva = associarVerificadorAosLocaisMateriaisRepository.findOne(codigo);
		if (associarVerificadorAosLocaisMateriaisSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return associarVerificadorAosLocaisMateriaisSalva;
	}

}
