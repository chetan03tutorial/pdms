package com.nataraj.management.auction.pdms.services.impl;


import com.nataraj.lib.exception.aem.ex.DataNotFoundException;
import com.nataraj.management.auction.pdms.dao.ProductDataLayer;
import com.nataraj.management.auction.pdms.entities.Product;
import com.nataraj.management.auction.pdms.services.ProductService;
import com.nataraj.management.auction.pdms.utils.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    private final ProductDataLayer pdal;
    private final LoggingService logger;

    @Autowired
    public ProductServiceImpl(ProductDataLayer pdal, LoggingService logger){
        this.pdal = pdal;
        this.logger = logger;
    }

    @Transactional
    @Override
    public List<Product> getProductsByCategory(String category) {
        return pdal.findByCategory(category);
    }

    @Override
    @Transactional
    public Product getProductById(Long productId) {
        Optional<Product> product = pdal.findById(productId);
        if(product.isPresent()){
            return product.get();
        }
        throw new DataNotFoundException("Searched Product with provided product Id is not found in the system" );
    }

    @Override
    @Transactional
    public Product addProduct(Product product){
        return pdal.save(product);
    }
}
