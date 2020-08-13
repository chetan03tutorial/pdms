package com.nataraj.management.auction.pdms.services;

import com.nataraj.management.auction.pdms.common.BaseServiceTest;
import com.nataraj.management.auction.pdms.dao.ProductDataLayer;
import com.nataraj.management.auction.pdms.entities.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductServiceTest extends BaseServiceTest {

    @MockBean
    private ProductDataLayer productDao;

    @Autowired
    private ProductService productService;

    @Test
    public void testSuccess_WhenProductsAreFetchedByCategory(){
        Product mock = new Product(1L, "Samsung Note 5", "Cellular", 1023L);
        when(productDao.findByCategory("Cellular")).thenReturn(Arrays.asList(mock));
        List<Product> actual = productService.getProductsByCategory("Cellular");
        assertThat(actual.size(),is(1));
    }


    @Test
    public void testSuccess_WhenProductsAreFetchedById(){
        Product mock = new Product(1L, "Samsung Note 5", "Cellular", 1023L);
        when(productDao.findById(Long.valueOf(1))).thenReturn(Optional.of(mock));
        Product actual = productService.getProductById(Long.valueOf(1));
        assertThat(actual.getName(),is(mock.getName()));
    }

    @Test
    public void testSuccess_WhenProductIsCreated(){
        Product mock = new Product(1L, "Samsung Note 5", "Cellular", 1023L);
    }
}
