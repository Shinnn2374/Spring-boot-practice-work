package com.example.springbootnewsportal.utils;

import com.example.springbootnewsportal.exception.ResourceNotFoundException;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repositoryes.UserRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Aspect
@Component
public class SecurityAspect {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN') or @securityService.canAccessUser(principal, #id)")
    public void checkUserPermission(JoinPoint joinPoint, Long id) throws AccessDeniedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User currentUser = userRepository.findByUsername(username);

        User targetUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        boolean isAdmin = currentUser.getRoles().contains("ROLE_ADMIN");
        boolean isModerator = currentUser.getRoles().contains("ROLE_MODERATOR");

        if (!isAdmin && !isModerator && !currentUser.getId().equals(targetUser.getId())) {
            throw new AccessDeniedException("You don't have permission to perform this action");
        }
    }
}