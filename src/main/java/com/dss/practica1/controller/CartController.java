package com.dss.practica1.controller;

import com.dss.practica1.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCart().getCartItems());
        return "cart";
    }

    @PostMapping("/add/{id}")
    public String addProductCart(@PathVariable("id") Long id) {
        cartService.addProductById(id);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{id}")
    public String removeCartItem(@PathVariable("id") int id) {
        cartService.removeProduct(id);
        return "redirect:/cart";
    }
}
