package com.dss.practica1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.dss.practica1.service.ProductService;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }
	
	@GetMapping({"/", "/index.html"})
	public String root() {
	    return "redirect:/index";
	}
	
	
	
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }
}
