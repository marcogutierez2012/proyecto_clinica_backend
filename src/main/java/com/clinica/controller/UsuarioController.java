package com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clinica.model.Usuario;
import com.clinica.service.UsuarioService;


@CrossOrigin
@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
		
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/listar")
	public ResponseEntity<?> listarUsuarios() {
		try {
	        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
	        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al listar los usuarios");
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
		if(usuarioService.existeUsuario(usuario.getUsuario())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario con nombre de usuario "+usuario.getUsuario()+ " ya existe, intente otro.");
		}
		if(usuarioService.existeDni(usuario.getDni())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario con dni "+usuario.getDni()+ " ya existe, intente otro.");
		}
		
		if(usuarioService.existeCorreo(usuario.getCorreo())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario con correo "+usuario.getCorreo()+ " ya existe, intente otro.");
		}
		if(usuarioService.existeTelefono(usuario.getTelefono())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario con telefono "+usuario.getTelefono()+ " ya existe, intente otro.");
		}
		
		try {
			Usuario nuevousuario = usuarioService.registrarUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente. ID: "
			+nuevousuario.getId()+", Nombre de usuario: "+nuevousuario.getUsuario());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al registar usuario");
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario){
		Usuario usuarioExistente = usuarioService.obtenerUsuarioPorId(usuario.getId());
	    if (usuarioExistente == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con ID: " + usuario.getId());
	    }
	    
	    if (!usuario.getDni().equals(usuarioExistente.getDni())) {
	        if (usuarioService.existeDni(usuario.getDni())) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario con DNI " + usuario.getDni() + " ya existe, intente otro.");
	        }
	    }
	    
	    if (!usuario.getCorreo().equals(usuarioExistente.getCorreo())) {
	        if (usuarioService.existeCorreo(usuario.getCorreo())) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario con correo " + usuario.getCorreo() + " ya existe, intente otro.");
	        }
	    }
	    
	    if (!usuario.getTelefono().equals(usuarioExistente.getTelefono())) {
	        if (usuarioService.existeTelefono(usuario.getTelefono())) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario con teléfono " + usuario.getTelefono() + " ya existe, intente otro.");
	        }
	    }
		try {
			Usuario usuarioactualizado = usuarioService.actualizarUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body("Usuario actualizado correctamente. ID: "
			+usuarioactualizado.getId()+", Nombre: "+usuarioactualizado.getUsuario());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al actualizar usuario");
		}
	}
	
	@DeleteMapping("/eliminar/{idusuario}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable("idusuario") Long id) {
	    try {
	        usuarioService.eliminarUsuario(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario eliminado correctamente.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al eliminar usuario");
	    }
	}
}
