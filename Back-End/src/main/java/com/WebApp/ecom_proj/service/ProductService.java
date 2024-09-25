package com.WebApp.ecom_proj.service;

import com.WebApp.ecom_proj.model.Product;
import com.WebApp.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imgFile) throws IOException {
        product.setImageName(imgFile.getOriginalFilename());
        product.setImageType(imgFile.getContentType());
        product.setImageData(imgFile.getBytes());
        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imgFile) {
        Product existingProduct = productRepo.findById(id).orElse(null);
        if (existingProduct == null) {
            return null;
        }
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setRelaseDate(product.getRelaseDate());
        existingProduct.setAvailable(product.isAvailable());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setImageName(imgFile.getOriginalFilename());
        existingProduct.setImageType(imgFile.getContentType());
        try {
            existingProduct.setImageData(imgFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productRepo.save(existingProduct);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}
