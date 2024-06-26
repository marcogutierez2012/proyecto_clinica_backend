package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;
import com.clinica.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;

	//@Autowired
    //private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		//String passwordEncriptado=passwordEncoder.encode(usuario.getPassword());
		//usuario.setPassword(passwordEncriptado);
		return usuarioRepository.save(usuario);
	}

	@Override
	public boolean existeUsuario(String usuario) {
		return usuarioRepository.existsByUsuario(usuario);
	}

	@Override
	public boolean existeCorreo(String correo) {
		return usuarioRepository.existsByCorreo(correo);
	}

	@Override
	public boolean existeTelefono(String telefono) {
		return usuarioRepository.existsByTelefono(telefono);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		Usuario usuarioactualizar=usuarioRepository.findById(usuario.getId());
		usuarioactualizar.setNombre(usuario.getNombre());
		usuarioactualizar.setApellido(usuario.getApellido());
		usuarioactualizar.setDni(usuario.getDni());
		usuarioactualizar.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioactualizar.setGenero(usuario.getGenero());
		usuarioactualizar.setCorreo(usuario.getCorreo());
		usuarioactualizar.setDireccion(usuario.getDireccion());
		usuarioactualizar.setTelefono(usuario.getTelefono());
		usuarioactualizar.setPassword(usuario.getPassword());
		//String passwordEncriptado=passwordEncoder.encode(usuario.getPassword());
		//usuarioactualizar.setPassword(passwordEncriptado);
		
		return usuarioRepository.save(usuarioactualizar);
	}

	@Override
	public void eliminarUsuario(Long id) {
		Usuario usuarioeliminar=usuarioRepository.findById(id);
		usuarioeliminar.setEstado(1);
		usuarioRepository.save(usuarioeliminar);
	}

	@Override
	public boolean existeDni(String dni) {
		return usuarioRepository.existsByDni(dni);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return usuarioRepository.usuariosActivos();
	}
	
}
