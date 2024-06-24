package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

	boolean existsByDni(String dni);
	
	boolean existsByCorreo(String correo);
	
	boolean existsByTelefono(String telefono);
	
	Medico findById(Long idmedico);
	
	Medico deleteById(Long idmedico);
}
