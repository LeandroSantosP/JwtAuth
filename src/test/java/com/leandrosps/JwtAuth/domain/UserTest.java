package com.leandrosps.JwtAuth.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Test
    void shouldBeAbleCreateAPassword(){
        Password pass = new Password("pass123");
        assertEquals(pass.getSalt(), 11);
        assertNotEquals(pass.getValue(), "pass123");
        System.out.println("current: "+pass.isValid("pass123"));
    }


    @Test
    void shouldBeAbleCreateAValidUser(){
        User user = User.create(
                new User.UserInput("john_doe_123", "johnDoe@email.com", "senha123", 21)
        );
        assertEquals(user.getEmail(), "johnDoe@email.com");
        assertEquals(user.getAge(), 21);
        assertNotNull(user);
    }


}