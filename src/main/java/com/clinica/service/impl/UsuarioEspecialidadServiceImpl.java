package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.UsuarioEspecialidad;
import com.clinica.repository.UsuarioEspecialidadRepository;
import com.clinica.service.UsuarioEspecialidadService;

@Service
public class UsuarioEspecialidadServiceImpl implements UsuarioEspecialidadService{

	@Autowired
	UsuarioEspecialidadRepository usuarioEspecialidadRepository;
	
	@Override
	public UsuarioEspecialidad registrarUsuarioEspecialidades(UsuarioEspecialidad usuesp) {
		// TODO Auto-generated method stub
		return usuarioEspecialidadRepository.save(usuesp);
	}

	@Override
	public List<UsuarioEspecialidad> listarUsuarioEspecialidades() {
		// TODO Auto-generated method stub
		return usuarioEspecialidadRepository.findAll();
	}

}
