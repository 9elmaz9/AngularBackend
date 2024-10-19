package com.example.AngularBackend.services;

import com.example.AngularBackend.models.CreateNewUserRequest;
import com.example.AngularBackend.models.UserEntity;
import com.example.AngularBackend.models.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(CreateNewUserRequest req) {
        UserEntity entity = new UserEntity();
        entity.setUsername(req.getUsername());
        entity.setPassword(req.getPassword());

        return entity;
    }

    public UserResponse toResponse(UserEntity entity) {
        return new UserResponse(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword()
        );
    }

    public UserEntity toEntity(UserResponse res) {
        UserEntity entity = new UserEntity();
        entity.setId(res.getId());
        entity.setUsername(res.getUsername());
        entity.setPassword(res.getPassword());

        return entity;
    }
}
