package com.webservices.webservice.services;

import com.webservices.webservice.entities.Category;
import com.webservices.webservice.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new RuntimeException("Category not found");
        }
        return category.get();
    }
}
