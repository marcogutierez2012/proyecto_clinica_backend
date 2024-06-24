package com.clinica.model;

import java.util.Date;

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
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(nullable = false)
	private String nombre;
	
    @Column(nullable = false)
	private String apellido;
	
    @Column(nullable = false, unique = true)
	private String dni;
	
    @Column(nullable = false)
	private Date fechaNacimiento;
	
    @Column(nullable = false)
	private String genero;
	
    @Column(nullable = false)
	private String direccion;
	
    @Column(nullable = false, unique = true)
	private String correo;
	
    @Column(nullable = false, unique = true)
	private String telefono;
	
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
	
}
