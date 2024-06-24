package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinica.model.Paciente;
import com.clinica.repository.PacienteRepository;
import com.clinica.service.PacienteService;

public class PacienteServiceImpl implements PacienteService {

	@Autowired
	PacienteRepository pacienteRepository;
	
	@Override
	public Paciente registrar(Paciente paciente) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(paciente);
	}

	@Override
	public List<Paciente> listarPacientes() {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente actualizar(Paciente paciente) {
		// TODO Auto-generated method stub		
		Paciente pacienteactualizar=pacienteRepository.findById(paciente.getId());
		pacienteactualizar.setNombre(paciente.getNombre());
		pacienteactualizar.setApellido(paciente.getApellido());
		pacienteactualizar.setDni(paciente.getDni());
		pacienteactualizar.setFechaNacimiento(paciente.getFechaNacimiento());
		pacienteactualizar.setGenero(paciente.getGenero());
		pacienteactualizar.setDireccion(paciente.getDireccion());
		pacienteactualizar.setCorreo(paciente.getCorreo());
		pacienteactualizar.setTelefono(paciente.getTelefono());
		
		return pacienteRepository.save(pacienteactualizar);
	}

	@Override
	public Paciente eliminar(Long idpaciente) {
		// TODO Auto-generated method stub
		Paciente pacienteeliminar=pacienteRepository.findById(idpaciente);
		
		return pacienteRepository.deleteById(pacienteeliminar.getId());
	}

}
