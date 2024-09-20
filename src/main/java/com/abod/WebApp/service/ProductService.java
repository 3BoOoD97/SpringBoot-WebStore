package com.abod.WebApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.abod.WebApp.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>( Arrays.asList(new Product(1, "Product 11", 100), new Product(2, "Product 2", 200)));




    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }


public void addProduct(Product product) {
    products.add(product);
}
}