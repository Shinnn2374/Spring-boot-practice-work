package com.example.skillboxsevenapp.model;

import com.example.skillboxsevenapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String id;
    private String username;
    private String password;
    private String email;
    private Set<String> roles;


    public static UserModel from(User user) {
        return new UserModel(user.getId(), user.getUsername(),user.getPassword(), user.getEmail(), user.getRoles());
    }
}
