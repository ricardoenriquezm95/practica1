package com.dss.practica1.service;

import com.dss.practica1.model.Cart;
import com.dss.practica1.model.Product;
import com.dss.practica1.repository.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class CartService {

    private final Cart cart = new Cart();
    private final ProductRepo productRepo;

    public CartService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Cart getCart() {
        return cart;
    }

    public void addProductById(Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("No existe el producto " + productId));
        cart.addProduct(product);
    }

    public void removeProduct(int index) {
        cart.removeProduct(index);
    }
}
