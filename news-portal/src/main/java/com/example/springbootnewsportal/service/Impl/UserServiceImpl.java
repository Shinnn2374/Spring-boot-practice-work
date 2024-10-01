package com.example.springbootnewsportal.service.Impl;

import ch.qos.logback.core.net.server.Client;
import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repository.UserRepository;
import com.example.springbootnewsportal.service.UserService;
import com.example.springbootnewsportal.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private UserRepository repository;


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("User with id: {0} not found", id)));
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User updatedClient = findById(user.getId());
        BeanUtils.copyNonNullProperties(user, updatedClient);
        return repository.save(updatedClient);
    }

    @Override
    public void deleteById(Long userId) {
        repository.deleteById(userId);
    }
}
