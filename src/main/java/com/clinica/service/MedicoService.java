package com.clinica.service;

import java.util.List;

import com.clinica.model.Medico;

public interface MedicoService {

	Medico registrar(Medico medico);
	
	List<Medico> listarMedicos();
	
	Medico actualizar(Medico medico);
	
	Medico eliminar(Long idmedico);
	
}
