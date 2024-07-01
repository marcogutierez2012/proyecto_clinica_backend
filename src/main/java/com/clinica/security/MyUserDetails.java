	package com.clinica.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.clinica.model.Rol;
import com.clinica.model.Usuario;




public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

	public MyUserDetails(Usuario usuario) {
		this.usuario = usuario;
	}
	
    public Usuario getUsuario() {
        return usuario;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	   
		 List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		    // Obtenemos el rol del usuario
		    Rol rol = usuario.getRol();
		    // Añadimos el rol como autoridad si no es nulo
		    if (rol != null) {
		    	String roleName = "" + rol.getNombre();
		        authorities.add(new SimpleGrantedAuthority(roleName));
		        System.out.println("Loaded role: " + roleName);  // Logging para verificar
		    } else {
		        System.out.println("No role found for user: " + usuario.getUsuario());
		    }
		    return authorities;
	}

	@Override
	public String getPassword() {
	
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		
		return usuario.getUsuario();
	}
	
	public Long getId() {
		return usuario.getId();
	}
	
	
	
	public String getApellido() {
		
		return usuario.getApellido();
	}
	
	public String getCorreo() {
		
		return usuario.getCorreo();
	}
	
	public String getDireccion() {
		
		return usuario.getDireccion();
	}
	
	public String getDni() {
		
		return usuario.getDni();
	
	}

	public Date getFechaNacimiento() {
		return usuario.getFechaNacimiento();
	}
	
	public String getGenero() {
		return usuario.getGenero();
	}
	
	public String getNombre() {
		return usuario.getNombre();
	}
	
	public String getTelefono() {
		return usuario.getTelefono();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return usuario.getEstado()==1;
	}
	
	
}
