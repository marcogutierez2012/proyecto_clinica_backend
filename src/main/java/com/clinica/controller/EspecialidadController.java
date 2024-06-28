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

import com.clinica.model.Especialidad;
import com.clinica.service.EspecialidadService;

@CrossOrigin
@RestController
@RequestMapping("especialidad")
public class EspecialidadController {
	
	@Autowired
	EspecialidadService especialidadService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarEspecialidades(){
		try {
			List<Especialidad> especialidades=especialidadService.listarEspecialidades();
			return ResponseEntity.status(HttpStatus.OK).body(especialidades);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al listar las especialidades.");
		}	
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarEspecialidad(@RequestBody Especialidad especialidad){
		if(especialidadService.existeNombreEspecialidad(especialidad.getNombre())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya existe una especialidad con el nombre : "
					+especialidad.getNombre());
		}
		
		try {
			Especialidad nuevaespecialidad=especialidadService.registrar(especialidad);
			return ResponseEntity.status(HttpStatus.CREATED).body("Especialidad registrada correctamente. ID: "
					+nuevaespecialidad.getId()+" Nombre : "+nuevaespecialidad.getNombre());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al registrar la especialidad.");
		}
	}

}
