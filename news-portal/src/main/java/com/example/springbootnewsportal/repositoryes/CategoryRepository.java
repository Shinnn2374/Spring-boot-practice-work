package com.example.springbootnewsportal.repositoryes;

import com.example.springbootnewsportal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
}
