package com.clinica.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class CitaMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime fechaCita;
	
    @ManyToOne
    @JoinColumn(name = "id_paciente")
	private Usuario paciente;
	
    @ManyToOne
    @JoinColumn(name = "id_medico")
	private Usuario medico;
	
    @Column(nullable = false)
	private int estado;
	
    @Column(nullable = false)
	private String motivoCita;
	
}
