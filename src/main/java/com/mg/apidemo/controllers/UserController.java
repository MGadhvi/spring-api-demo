package com.mg.apidemo.controllers;

import com.mg.apidemo.entities.UserEntity;
import com.mg.apidemo.repositories.UserEntityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserEntityRepository userEntityRepository;

    public UserController(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }
}
