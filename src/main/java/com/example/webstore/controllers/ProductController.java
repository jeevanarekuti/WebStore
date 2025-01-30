package com.example.webstore.controllers;

import com.example.webstore.dtos.CreateProductRequestDTO;
import com.example.webstore.dtos.UpdateProjectRequestDTO;
import com.example.webstore.models.Product;
import com.example.webstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/")
    public Product addProduct(@RequestBody CreateProductRequestDTO dto) {
        Product product = productService.addProduct(dto.getName(), dto.getDescription(), dto.getPrice(), dto.getCategory_name(), dto.getQuantity());
        return product;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id, @RequestBody UpdateProjectRequestDTO dto) {
        Product product = productService.updateProduct(id, dto.getName(), dto.getDescription(), dto.getPrice());
        return product;
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable("id") long id) {
        return productService.deleteProductById(id);
    }



}
