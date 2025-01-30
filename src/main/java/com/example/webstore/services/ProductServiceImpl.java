package com.example.webstore.services;

import com.example.webstore.models.Category;
import com.example.webstore.models.Product;
import com.example.webstore.repositories.CategoryRepository;
import com.example.webstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(String name, String description, double price, String category_name , int quantity) {
        Category category = categoryService.createCategory(category_name);
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(category);
        Product product1 = productRepository.save(product);
        categoryService.addProduct(product1,category_name);
        return product1;
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = optional.get();
        return product;
    }

    @Override
    public Product updateProduct(long id, String name, String description, double price) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = optional.get();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProductById(long id) {
        productRepository.deleteById(id);
        return true;
    }
}
