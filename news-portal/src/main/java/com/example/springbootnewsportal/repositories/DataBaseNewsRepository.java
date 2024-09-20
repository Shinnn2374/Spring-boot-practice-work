package com.example.springbootnewsportal.repositories;

import com.example.springbootnewsportal.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBaseNewsRepository extends JpaRepository<News,Long> {
}
