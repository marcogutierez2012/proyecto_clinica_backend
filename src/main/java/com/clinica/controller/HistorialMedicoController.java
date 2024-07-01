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

import com.clinica.model.HistorialMedico;
import com.clinica.service.HistorialMedicoService;

@CrossOrigin
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("historial-medico")
public class HistorialMedicoController {

	@Autowired
	HistorialMedicoService historialMedicoService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarHistorialMedico(){
		try {
			List<HistorialMedico> historialmedico=historialMedicoService.listarHistorial();
			return ResponseEntity.status(HttpStatus.OK).body(historialmedico);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al listar el historial medico");
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarHistorialMedico(@RequestBody HistorialMedico historialmedico){
		try {
			HistorialMedico nuevohistorial=historialMedicoService.registrar(historialmedico);
			return ResponseEntity.status(HttpStatus.CREATED).body("Registro agregado al historial correctamente. ID :"
			+nuevohistorial.getId()+" Paciente : "+nuevohistorial.getPaciente().getNombre()+" "+nuevohistorial.getPaciente().getApellido()
			+" Medico : "+nuevohistorial.getMedico().getNombre()+" "+nuevohistorial.getMedico().getApellido()+" Fecha de Consulta : "
			+nuevohistorial.getFechaConsulta());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al agregar un registro en el historial.");
		}
	}
	
}