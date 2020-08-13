package com.nataraj.management.auction.pdms.services;

import com.nataraj.management.auction.pdms.entities.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProductsByCategory(String category);
    public Product getProductById(Long productId);
    public Product addProduct(Product product);
}
