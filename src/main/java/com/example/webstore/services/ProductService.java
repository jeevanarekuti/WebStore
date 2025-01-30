package com.example.webstore.services;

import com.example.webstore.models.Category;
import com.example.webstore.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product addProduct(String name, String description, double price, String  category_name, int quantity);
    Product getProductById(long id);
    Product updateProduct(long id,String name, String description, double price);
    boolean deleteProductById(long id);
}
