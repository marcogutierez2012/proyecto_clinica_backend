package com.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clinica.model.Usuario;
import com.clinica.repository.UsuarioRepository;
import com.clinica.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usurepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usurepo.findByUsuario(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return new MyUserDetails(usuario);
	}

}
