package com.clinica.model;

import java.io.Serializable;
import java.time.LocalDate;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "historial_medico")
public class HistorialMedico{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "id_paciente")
	private Usuario paciente;
    
    @ManyToOne
    @JoinColumn(name = "id_medico")
	private Usuario medico;
	
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
	private LocalDate fechaConsulta;
	
    @Column(nullable = false)
	private String diagnostico;
	
    @Column(nullable = false)
	private String tratamiento;
	
    @Column(nullable = false)
	private String notaAdicional;
    
    @Column(nullable = false)
    private int estado;
    
	
}
