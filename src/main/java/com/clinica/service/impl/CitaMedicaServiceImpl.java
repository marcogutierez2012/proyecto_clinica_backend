package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinica.model.CitaMedica;
import com.clinica.repository.CitaMedicaRepository;
import com.clinica.service.CitaMedicaService;

public class CitaMedicaServiceImpl implements CitaMedicaService{

	@Autowired
	CitaMedicaRepository citaMedicaRepository;
	
	@Override
	public CitaMedica registrar(CitaMedica citamedica) {
		// TODO Auto-generated method stub
		return citaMedicaRepository.save(citamedica);
	}

	@Override
	public List<CitaMedica> listarCitas() {
		// TODO Auto-generated method stub
		return citaMedicaRepository.findAll();
	}

}
