package com.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;
import com.clinica.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Usuario registrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
}
