package com.dss.practica1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dss.practica1.model.Producto;
import com.dss.practica1.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
    // Mostrar todos los productos
    @GetMapping
    public String getAllProducts(Model model) {
        List<Producto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productos";
    }

    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable Long id) {
    	return productService.getProductById(id);
    }
		
    //con este metodo anhadimos o modificamos
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Producto producto) {
        productService.saveProduct(producto);
        return "redirect:/products";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        try {
            productService.deleteProduct(id);
        } catch (Exception e) {
            
        	// Capturamos la excepcion
            e.printStackTrace();
            
            model.addAttribute("errorMessage", "No se eliminó el producto: " + e.getMessage());
            return "error";
        }
        return "redirect:/products";
    }

}
