package com.webservices.webservice.repositories;

import com.webservices.webservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
