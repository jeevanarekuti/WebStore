package com.example.webstore.services;

import com.example.webstore.models.Category;
import com.example.webstore.models.Product;

import java.util.List;

public interface CategoryService {
    public Category createCategory(String category);
    public Category getProductsByCategory(long id);
    public List<Category> getAllCategories();
    public boolean addProduct(Product product, String category_name);
}
