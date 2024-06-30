package com.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinica.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	boolean existsByUsuario(String usuario);
	
	boolean existsByDni(String dni);
	
	boolean existsByCorreo(String correo);
	
	boolean existsByTelefono(String telefono);
	
	Usuario findById(Long id);
	
	Usuario findByUsuario(String usuario);
	
	
	@Query("SELECT u FROM Usuario u WHERE u.estado = 1")
	List<Usuario> usuariosActivos();
	
	void deleteById(Long id);
	
}
