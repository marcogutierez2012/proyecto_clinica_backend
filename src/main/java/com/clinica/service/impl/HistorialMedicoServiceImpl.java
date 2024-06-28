package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.HistorialMedico;
import com.clinica.repository.HistorialMedicoRepository;
import com.clinica.service.HistorialMedicoService;

@Service
public class HistorialMedicoServiceImpl implements HistorialMedicoService{

	@Autowired
	HistorialMedicoRepository historialMedicoRepository;
	
	@Override
	public HistorialMedico registrar(HistorialMedico historialmedico) {
		// TODO Auto-generated method stub
		return historialMedicoRepository.save(historialmedico);
	}

	@Override
	public List<HistorialMedico> listarHistorial() {
		// TODO Auto-generated method stub
		return historialMedicoRepository.findAll();
	}

	
}
