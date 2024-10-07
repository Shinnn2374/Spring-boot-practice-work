package com.example.springbootnewsportal.repositoryes;

import com.example.springbootnewsportal.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>
{
}
