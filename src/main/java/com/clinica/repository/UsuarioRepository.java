package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	boolean existsByUsuario(String usuario);
	
	boolean existsByDni(String dni);
	
	boolean existsByCorreo(String correo);
	
	boolean existsByTelefono(String telefono);
	
	Usuario findById(Long id);
	
	void deleteById(Long id);
	
}
