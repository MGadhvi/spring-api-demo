package com.mg.apidemo.controllers;

import com.mg.apidemo.exceptions.UserNotFoundException;
import com.mg.apidemo.entities.UserEntity;
import com.mg.apidemo.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserController(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable Integer id) throws UserNotFoundException {
        return userEntityRepository.getUserEntityById(id).orElseThrow(() -> new UserNotFoundException("No such entity"));
    }
}
