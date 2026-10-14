package com.dss.practica1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dss.practica1.model.Product;
import com.dss.practica1.repository.ProductRepo;

@Service
public class ProductService {

	private final ProductRepo productRepo;

	ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Product getProductById(Long id){
		return productRepo.findById(id).orElseThrow();
	}
	
	public void saveProduct(Product producto){
		productRepo.save(producto);
	}
	
	public void deleteProduct(Long id){
		productRepo.deleteById(id);
	}
	
}
