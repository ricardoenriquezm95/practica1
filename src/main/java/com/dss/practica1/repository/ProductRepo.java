package com.dss.practica1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dss.practica1.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
}
