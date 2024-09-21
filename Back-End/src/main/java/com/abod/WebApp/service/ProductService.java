package com.abod.WebApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.abod.WebApp.model.Product;
import com.abod.WebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;


  //  List<Product> products = new ArrayList<>( Arrays.asList(new Product(1, "Product 11", 100), new Product(2, "Product 2", 200)));

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }


public void addProduct(Product product) {
        productRepo.save(product);
}

    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
        }
}