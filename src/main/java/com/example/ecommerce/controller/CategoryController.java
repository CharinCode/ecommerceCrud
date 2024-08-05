package com.example.ecommerce.controller;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> allcategories = categoryService.getAllcategories();
        return new ResponseEntity<>(allcategories, HttpStatus.OK);
    }

    @PostMapping("/admin/category")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Created category successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/public/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") long id) {
        try {
            String status = categoryService.deleteCategory(id);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException reEx) {
            return new ResponseEntity<>(reEx.getReason(), reEx.getStatusCode());
        }
    }

    @PutMapping("/public/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category categoryUpdate) {
        try {
            String response = categoryService.updateCategory(id, categoryUpdate);
            return ResponseEntity.ok(response);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
