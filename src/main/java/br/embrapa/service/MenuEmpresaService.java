package br.embrapa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.MenuEmpresa;
import br.embrapa.repository.MenuEmpresaRepository;

@Service
public class MenuEmpresaService {

	@Autowired
	private MenuEmpresaRepository menuEmpresaRepository;

	public MenuEmpresa atualizar(Long codigo, MenuEmpresa menuEmpresa) {
		
		MenuEmpresa menuEmpresaSalva = buscarEmpresaPeloCodigo(codigo);
		BeanUtils.copyProperties(menuEmpresa, menuEmpresaSalva, "codigo");
		return menuEmpresaRepository.save(menuEmpresaSalva);
	}
	
	

	public MenuEmpresa buscarEmpresaPeloCodigo(Long codigo) {
		MenuEmpresa menuEmpresaSalva = menuEmpresaRepository.findOne(codigo);
		if (menuEmpresaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return menuEmpresaSalva;
	}
}
