package com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.model.CitaMedica;
import com.clinica.service.CitaMedicaService;

@CrossOrigin
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("cita-medica")
public class CitaMedicaController {

	@Autowired
	CitaMedicaService citaMedicaService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarCitasMedicas(){
		try {
			List<CitaMedica> citasmedicas=citaMedicaService.listarCitas();
			return ResponseEntity.status(HttpStatus.OK).body(citasmedicas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al listar citas medicas");
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarCitaMedica(@RequestBody CitaMedica citaMedica){
		try {
			CitaMedica nuevacita=citaMedicaService.registrar(citaMedica);
			return ResponseEntity.status(HttpStatus.CREATED).body("Cita medica regitrada correctamente. ID :"
					+nuevacita.getId()+" Paciente : "+nuevacita.getPaciente().getNombre()+" "+nuevacita.getPaciente().getApellido()
					+" Medico : "+nuevacita.getMedico().getNombre()+" "+nuevacita.getMedico().getApellido()
					+" Fecha : "+nuevacita.getFechaCita());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al registrar la cita medica");
		}
	}
	
}
