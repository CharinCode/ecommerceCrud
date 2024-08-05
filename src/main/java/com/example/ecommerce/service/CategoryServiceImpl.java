package com.example.ecommerce.service;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllcategories() {
        return categoryRepo.findAll();
    }

    @Override
    public void createCategory(Category category) {
      categoryRepo.save(category);
    }

    @Override
    public String deleteCategory(Long id) {
        Category categoryById = categoryRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Response not found"));
        categoryRepo.deleteById(categoryById.getId());
        return "Deleted ID : " + id;
    }

    @Override
    public String updateCategory(Long id, Category category) {
        Category categoryById = categoryRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Response not found"));
        categoryById.setCategoryName(category.getCategoryName());
        categoryRepo.save(categoryById);
        return "Updated";
    }
}
