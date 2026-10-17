package com.dss.practica1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Carrito simplificado en memoria (Parte 4 del guion): una lista de Product.
 */
public class Cart {

    private final List<Product> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public void removeProduct(int index) {
        if (index >= 0 && index < cartItems.size()) {
            cartItems.remove(index);
        }
    }
}
