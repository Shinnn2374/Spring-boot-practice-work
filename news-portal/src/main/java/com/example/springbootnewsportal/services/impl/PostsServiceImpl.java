package com.example.springbootnewsportal.services.impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.Posts;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repositoryes.PostsRepository;
import com.example.springbootnewsportal.services.PostsService;
import com.example.springbootnewsportal.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService
{
    private PostsRepository postsRepository;

    @Override
    public List<Posts> findAll() {
        return postsRepository.findAll();
    }

    @Override
    public Posts findById(Long id) {
        return postsRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("Posts with id {0} not found", id)));
    }

    @Override
    public Posts save(Posts posts) {
        return postsRepository.save(posts);
    }

    @Override
    public Posts update(Posts posts) {
        Posts newPost = findById(posts.getId());
        BeanUtils.copyNonNullProperties(posts, newPost);
        return postsRepository.save(newPost);
    }

    @Override
    public void deleteById(Long id) {
        postsRepository.deleteById(id);
    }
}
