package com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.model.UsuarioEspecialidad;
import com.clinica.service.UsuarioEspecialidadService;

@CrossOrigin
@RestController
@RequestMapping("usuario-especialidad")
public class UsuarioEspecialidadController {

	@Autowired
	UsuarioEspecialidadService usuarioEspecialidadService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarUsuarioEspecialidad(){
		try {
			List<UsuarioEspecialidad> usuarioEspecialidades=usuarioEspecialidadService.listarUsuarioEspecialidades();
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(usuarioEspecialidades);
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Se produjo un error al listar los usuarios y sus especialidades.");
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuarioEspecialidad(@RequestBody UsuarioEspecialidad usuarioEspecialidad){
		try {
			UsuarioEspecialidad nuevousuarioEspecialidad=usuarioEspecialidadService.registrarUsuarioEspecialidades(usuarioEspecialidad);
			return ResponseEntity.status(HttpStatus.CREATED).body("Especialidad agregada al usuario correctamente. ID :"
					+nuevousuarioEspecialidad.getId()+" Usuario : "+nuevousuarioEspecialidad.getMedico().getNombre()+" "
					+" "+nuevousuarioEspecialidad.getMedico().getApellido()+" Especialidad : "+nuevousuarioEspecialidad.getEspecialidad().getNombre());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al asignar una especialidad al usuario.");
		}
	}
}
