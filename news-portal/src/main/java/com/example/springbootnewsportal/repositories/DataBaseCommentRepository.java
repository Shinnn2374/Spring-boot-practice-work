package com.example.springbootnewsportal.repositories;

import com.example.springbootnewsportal.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBaseCommentRepository extends JpaRepository<Comment,Long> {
}
