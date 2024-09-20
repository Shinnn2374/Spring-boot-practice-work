package com.example.springbootnewsportal.repositories;

import com.example.springbootnewsportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBaseUserRepository extends JpaRepository<User, Long> {
}
