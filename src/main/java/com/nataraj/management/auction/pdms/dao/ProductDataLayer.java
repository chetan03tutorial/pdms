package com.nataraj.management.auction.pdms.dao;

import com.nataraj.management.auction.pdms.entities.Product;

import java.util.List;

public interface ProductDataLayer extends SimpleJpaBaseRepository<Product,Long> {

    public List<Product> findByCategory(String category);
}
