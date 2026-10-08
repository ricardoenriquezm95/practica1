package com.dss.practica1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Producto { 
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private Long id; 
private String nombre; 
private double precio; 


// Constructors, Getters, Setters 

}
