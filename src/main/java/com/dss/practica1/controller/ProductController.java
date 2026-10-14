package com.dss.practica1.controller;

import com.dss.practica1.model.Product;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dss.practica1.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
	
    // Mostrar todos los productos
    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productos";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
    	model.addAttribute("product", new Product());
        return "formulario-producto";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
    	Product producto = productService.getProductById(id);
        model.addAttribute("product", producto);
        return "formulario-producto";
    }
    

    //con este metodo anhadimos o modificamos
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product producto) {
        productService.saveProduct(producto);
        return "redirect:/products";
    }
    
    @PostMapping("/delete/{id}")
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
