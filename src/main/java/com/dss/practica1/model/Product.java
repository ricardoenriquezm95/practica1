package com.dss.practica1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name; 
	private double price;
	
	
	//esto se debe de eliminar con lombook
//Constructors, Getters, Setters 
public Product(Long id, String name, double price) {
	this.id = id;
	this.name = name;
	this.price = price;
}

public Product() {
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}


}
