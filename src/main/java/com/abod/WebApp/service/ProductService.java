package com.abod.WebApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.abod.WebApp.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    List<Product> products = Arrays.asList(new Product(1, "Product 11", 100), new Product(2, "Product 2", 200));




    public List<Product> getProducts() {
        return products;
    }
}
