package com.clinica.service;

import java.util.List;

import com.clinica.model.HistorialMedico;

public interface HistorialMedicoService {

	HistorialMedico registrar(HistorialMedico historialmedico);
	
	List<HistorialMedico> listarHistorial();
	
}
