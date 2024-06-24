package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	boolean existsByUsuario(String usuario);
	
	boolean existsByCorreo(String correo);
	
	boolean existsByTelefono(String telefono);
	
}
