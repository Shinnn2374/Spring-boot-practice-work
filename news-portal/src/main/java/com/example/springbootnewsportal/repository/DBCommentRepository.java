package com.example.springbootnewsportal.repository;

import com.example.springbootnewsportal.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBCommentRepository extends JpaRepository<Comment,Long>
{
}
