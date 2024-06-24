package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.model.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {

	boolean existsByNombre(String nombre);
	
}
