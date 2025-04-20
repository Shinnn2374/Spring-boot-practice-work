package com.example.springbootnewsportal.repositoryes;

import com.example.springbootnewsportal.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
}
