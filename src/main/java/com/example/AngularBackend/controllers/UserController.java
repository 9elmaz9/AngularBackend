package com.example.AngularBackend.controllers;

import com.example.AngularBackend.models.UserResponse;
import com.example.AngularBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<UserResponse> all(@RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "50") Integer size) {

        return userService.read(page, size);
    }


}
