package com.clinica.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cita_medica")
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(nullable = false)
	private LocalDateTime fechaCita;
	
    @ManyToOne
    @JoinColumn(name = "id_paciente")
	private Paciente paciente;
	
    @ManyToOne
    @JoinColumn(name = "id_medico")
	private Medico medico;
	
    @Column(nullable = false)
	private int estado;
	
    @Column(nullable = false)
	private String motivoCita;
	
}
