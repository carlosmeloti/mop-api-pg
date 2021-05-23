package br.embrapa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.Verificador_Local_m;
import br.embrapa.repository.Verificador_Local_mRepository;


@Service
public class Verificador_Local_mService {

	@Autowired
	private Verificador_Local_mRepository verificador_Local_mRepository;
	
	public Verificador_Local_m atualizar(Long codigo, Verificador_Local_m verificador_Local_m) {
		
		Verificador_Local_m verificador_Local_mSalva = buscarVerificadorPeloCodigo(codigo);
		BeanUtils.copyProperties(verificador_Local_m, verificador_Local_mSalva, "codigo");
		return verificador_Local_mRepository.save(verificador_Local_mSalva);
	}
	

	public Verificador_Local_m buscarVerificadorPeloCodigo(Long codigo) {
		Verificador_Local_m verificador_Local_mSalva = verificador_Local_mRepository.findOne(codigo);
		if (verificador_Local_mSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return verificador_Local_mSalva;
	}
}
