package com.webservices.webservice.services;

import com.webservices.webservice.entities.Product;
import com.webservices.webservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
