package com.mg.apidemo;

import com.mg.apidemo.controllers.UserController;
import com.mg.apidemo.entities.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
class ApiDemoApplicationTests {

    private WebTestClient testClient;

    @Autowired
    private UserController userController;

    @BeforeEach
    void setup() {
        testClient = WebTestClient.bindToController(userController).build();
    }

    @Test
    @DisplayName("Check that status code is 200")
    void checkThatStatusCodeIs200() {
        testClient
                .get()
                .uri("http://localhost:8080/users")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @DisplayName("Check that the first user is Alice")
    void checkThatTheFirstAuthorIsAlice() {
        testClient
                .get()
                .uri("https://localhost:8000/user/1")
                .exchange()
                .expectBody(UserEntity.class)
                .value(userEntity -> Assertions.assertEquals("Alice", userEntity.getName()));
    }

}
