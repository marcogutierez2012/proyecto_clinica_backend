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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(nullable = false, unique = true)
	private String usuario;
    
    @Column(nullable = false)
   	private String nombre;
   	
    @Column(nullable = false)
   	private String apellido;
   	
    @Column(nullable = false, unique = true)
   	private String dni;
   	
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
   	private Date fechaNacimiento;
   	
    @Column(nullable = false)
   	private String genero;
   	
    @Column(nullable = false)
   	private String direccion;
	
    @Column(nullable = false, unique = true)
	private String correo;
	
    @Column(nullable = false, unique = true)
	private String telefono;
	
    @Column(nullable = false)
	private String password;
    
    @Column(nullable = false)
    private int estado;
    
    @ManyToOne
    @JoinColumn(name = "id_rol")
	private Rol rol;
    
	
}
