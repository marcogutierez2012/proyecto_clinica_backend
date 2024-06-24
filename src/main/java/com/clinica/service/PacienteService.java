package com.clinica.service;

import java.util.List;

import com.clinica.model.Paciente;

public interface PacienteService {

	Paciente registrar(Paciente paciente);
	
	List<Paciente> listarPacientes();
	
	Paciente actualizar(Paciente paciente);
	
	Paciente eliminar(Long idpaciente);
	
}
