package com.clinica.model;

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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(nullable = false, unique = true)
	private String usuario;
	
    @Column(nullable = false, unique = true)
	private String correo;
	
    @Column(nullable = false, unique = true)
	private String telefono;
	
    @Column(nullable = false)
	private String password;
	
    @ManyToOne
    @JoinColumn(name = "id_rol")
	private Rol rol;
	
}
