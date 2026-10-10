package com.dss.practica1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.dss.practica1.model.Cart;
import com.dss.practica1.model.Product;
import com.dss.practica1.repository.ProductRepo;

@Service
@SessionScope
public class CartService {
	
    private final Cart cart = new Cart();

    public Cart getCart() {
        return cart;
    }

    public void addProduct(Product product) {
        cart.addProduct(product);
    }

    public void removeProduct(Long productId) {
        cart.removeProduct(productId);
    }
}
