package com.example.skillboxsevenapp.entity;

import com.example.skillboxsevenapp.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String username;
    private String email;

    public static User from(UserModel model){
        return new User(model.getId(), model.getUsername(), model.getEmail());
    }
}
