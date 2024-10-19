package com.example.AngularBackend.services;

import com.example.AngularBackend.models.CreateNewUserRequest;
import com.example.AngularBackend.models.UserEntity;
import com.example.AngularBackend.models.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    // DI: Dependency Injection
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(@Autowired UserRepository userRepository, @Autowired UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // CRUD: Create, Read, Update, Delete
    public UserResponse create(CreateNewUserRequest req) throws UserAlreadyExistsException {

        Optional<UserEntity> foundUser = userRepository.findByUsername(req.getUsername());

        if (foundUser.isPresent()) {
            throw new UserAlreadyExistsException(
                    "User with username: " + foundUser.get().getUsername() + " already exists.");
        }

        UserEntity userToCreate = userMapper.toEntity(req);
        UserEntity savedEntity = userRepository.save(userToCreate);

        return userMapper.toResponse(savedEntity);
    }

    public List<UserResponse> read() {
        List<UserResponse> responses = new ArrayList<>();

        List<UserEntity> entities = userRepository.findAll();

        for (UserEntity entity : entities) {
            UserResponse res = userMapper.toResponse(entity);
            responses.add(res);
        }

        return responses;
    }

    public List<UserResponse> read(int page, int size) {
        List<UserResponse> responses = new ArrayList<>();

        List<UserEntity> entities = userRepository.findAll(PageRequest.of(page, size)).toList();

        for (UserEntity entity : entities) {
            UserResponse res = userMapper.toResponse(entity);
            responses.add(res);
        }

        return responses;
    }

    public UserResponse read(UUID id) throws UserNotFoundException {

        Optional<UserEntity> oEntity = userRepository.findById(id);

        if (oEntity.isEmpty()) {
            throw new UserNotFoundException("User with " + id + " is NOT found!");
        }

        return userMapper.toResponse(oEntity.get());
    }


}
