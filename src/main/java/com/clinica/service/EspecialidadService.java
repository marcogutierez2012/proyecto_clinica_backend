package com.clinica.service;

import java.util.List;

import com.clinica.model.Especialidad;

public interface EspecialidadService {

	Especialidad registrar(Especialidad especialidad);
	
	List<Especialidad> listarEspecialidades();
	
}
