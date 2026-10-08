package com.dss.practica1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dss.practica1.model.Producto;
import com.dss.practica1.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public List<Producto> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Producto getProductById(Long id){
		return productRepo.getById(id);
	}
	
	public void saveProduct(Producto producto){
		productRepo.save(producto);
	}
	
	public void deleteProduct(Producto producto){
		productRepo.delete(producto);
	}
	
}
