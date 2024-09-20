package com.example.springbootnewsportal.repositories;

import com.example.springbootnewsportal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBaseCategoryRepository extends JpaRepository<Category, Long> {
}
