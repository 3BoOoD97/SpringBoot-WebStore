package com.abod.WebApp.controller;

import com.abod.WebApp.model.Product;
import com.abod.WebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService ;


    @GetMapping("/products")
    public List getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping ("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
}

