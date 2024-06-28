package com.clinica.service;

import java.util.List;

import com.clinica.model.UsuarioEspecialidad;

public interface UsuarioEspecialidadService {

	UsuarioEspecialidad registrarUsuarioEspecialidades(UsuarioEspecialidad usuesp);
	
	List<UsuarioEspecialidad> listarUsuarioEspecialidades();
	
}
