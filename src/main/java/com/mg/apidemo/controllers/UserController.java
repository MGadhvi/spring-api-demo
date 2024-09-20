package com.mg.apidemo.controllers;

import com.mg.apidemo.exceptions.UserNotFoundException;
import com.mg.apidemo.entities.UserEntity;
import com.mg.apidemo.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserController(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers(@RequestParam(required = false) String name) {
        if (name == null) {
            return userEntityRepository.findAll();
        }

            List<UserEntity> usersFoundByName = new ArrayList<>();


            for (UserEntity userEntity : userEntityRepository.findAll()) {
                if (userEntity.getName().contains(name)) {
                    usersFoundByName.add(userEntity);
                }
            }
        return usersFoundByName;
    }

    @PostMapping("/user")
    public String addUser(@RequestBody UserEntity userEntity) {
        userEntity.setCreatedAt(LocalDateTime.now());
        userEntityRepository.save(userEntity);
        return userEntity.getName() + " added to database";
    }

    @GetMapping("/user/{id}")
    public UserEntity getUserById(@PathVariable Integer id) throws UserNotFoundException {
        return userEntityRepository.getUserEntityById(id).orElseThrow(() -> new UserNotFoundException("No such entity"));
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        userEntityRepository.deleteById(id);
    }

}
