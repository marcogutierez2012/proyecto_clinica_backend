package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinica.model.Medico;
import com.clinica.repository.MedicoRepository;
import com.clinica.service.MedicoService;

public class MedicoServiceImpl implements MedicoService {

	@Autowired
	MedicoRepository medicoRepository;
	
	@Override
	public Medico registrar(Medico medico) {
		// TODO Auto-generated method stub
		return medicoRepository.save(medico);
	}

	@Override
	public List<Medico> listarMedicos() {
		// TODO Auto-generated method stub
		return medicoRepository.findAll();
	}

	@Override
	public Medico actualizar(Medico medico) {
		// TODO Auto-generated method stub
		Medico medicoactualizar=medicoRepository.findById(medico.getId());
		medicoactualizar.setNombre(medico.getNombre());
		medicoactualizar.setApellido(medico.getApellido());
		medicoactualizar.setDni(medico.getDni());
		medicoactualizar.setFechaNacimiento(medico.getFechaNacimiento());
		medicoactualizar.setGenero(medico.getGenero());
		medicoactualizar.setDireccion(medico.getDireccion());
		medicoactualizar.setCorreo(medico.getCorreo());
		medicoactualizar.setTelefono(medico.getTelefono());
		medicoactualizar.setEspecialidad(medico.getEspecialidad());
		
		return medicoRepository.save(medicoactualizar);
	}

	@Override
	public Medico eliminar(Long idmedico) {
		// TODO Auto-generated method stub
		Medico medicoeliminar=medicoRepository.findById(idmedico);
		
		return medicoRepository.deleteById(medicoeliminar.getId());
	}

	
	
}
