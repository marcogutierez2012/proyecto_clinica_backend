package com.clinica.service;

import java.util.List;

import com.clinica.model.Usuario;

public interface UsuarioService {

	Usuario registrarUsuario(Usuario usuario);
	
	List<Usuario> obtenerUsuarios();
	
	Usuario obtenerUsuarioPorId(Long id);
	
	Usuario actualizarUsuario(Usuario usuario);
	
	void eliminarUsuario(Long id);
	
	boolean existeUsuario(String usuario);
	
	boolean existeDni(String dni);
	
	boolean existeCorreo(String correo);
	
	boolean existeTelefono(String telefono);
}
