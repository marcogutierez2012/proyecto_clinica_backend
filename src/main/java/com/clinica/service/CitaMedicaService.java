package com.clinica.service;

import java.util.List;

import com.clinica.model.CitaMedica;

public interface CitaMedicaService {

	CitaMedica registrar(CitaMedica citamedica);
	
	List<CitaMedica> listarCitas();

}
