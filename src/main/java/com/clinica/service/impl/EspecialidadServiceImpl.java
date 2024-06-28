package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.Especialidad;
import com.clinica.repository.EspecialidadRepository;
import com.clinica.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

	@Autowired
	EspecialidadRepository especialidadRepository;
	
	@Override
	public Especialidad registrar(Especialidad especialidad) {
		// TODO Auto-generated method stub
		return especialidadRepository.save(especialidad);
	}

	@Override
	public List<Especialidad> listarEspecialidades() {
		// TODO Auto-generated method stub
		return especialidadRepository.findAll();
	}

	@Override
	public boolean existeNombreEspecialidad(String nombre) {
		// TODO Auto-generated method stub
		return especialidadRepository.existsByNombre(nombre);
	}

}
