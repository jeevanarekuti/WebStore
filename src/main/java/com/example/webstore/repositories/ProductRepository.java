package com.example.webstore.repositories;

import com.example.webstore.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Product save(Product product);
    Product findByName(String name);
    boolean deleteById(long id);
    Optional<Product> findById(long id);
}
