package com.example.springbootnewsportal.repository;

import com.example.springbootnewsportal.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
