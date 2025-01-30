package com.example.webstore.services;

import com.example.webstore.models.Category;
import com.example.webstore.models.Product;
import com.example.webstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean addProduct(Product product, String category_name) {
        Optional<Category> optionalCategory = categoryRepository.findByName(category_name);
        Category category = optionalCategory.get();
        category.getProducts().add(product);
        categoryRepository.save(category);
        return true;
    }

    @Override
    public Category getProductsByCategory(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(String category) {
        Optional<Category> optional = categoryRepository.findByName(category);
        if(optional.isPresent()) {
            return optional.get();
        }
        else {
            Category newCategory = new Category();
            newCategory.setName(category);
            return categoryRepository.save(newCategory);
        }
    }
}
