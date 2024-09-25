package com.WebApp.ecom_proj.repo;

import com.WebApp.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo  extends JpaRepository<Product, Integer> {


    @Query("SELECT p FROM Product p WHERE lower(p.name) LIKE lower(CONCAT( '%',:keyword, '%'))"
            + " OR lower(p.brand) LIKE lower(CONCAT( '%',:keyword, '%'))"
            + " OR lower(p.category) LIKE lower(CONCAT( '%',:keyword, '%'))"
            + " OR lower(p.description) LIKE lower(CONCAT( '%',:keyword, '%'))")
     List<Product> searchProducts(String keyword);

}
