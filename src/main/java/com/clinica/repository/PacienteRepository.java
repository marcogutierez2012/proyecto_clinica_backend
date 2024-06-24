package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

	boolean existsByDni(String dni);
	
	boolean existsByCorreo(String correo);
	
	boolean existsByTelefono(String telefono);
	
	Paciente findById(Long idpaciente);
	
	Paciente deleteById(Long idpaciente);
	
}

