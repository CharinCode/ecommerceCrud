package com.example.ecommerce.service;

import com.example.ecommerce.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllcategories();
    void createCategory(Category category);
    String deleteCategory(Long id);
    String updateCategory(Long id,Category category);
}
