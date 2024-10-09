package com.webservices.webservice.controllers;

import com.webservices.webservice.entities.Category;
import com.webservices.webservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id){
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok().body(category);
    }
}
