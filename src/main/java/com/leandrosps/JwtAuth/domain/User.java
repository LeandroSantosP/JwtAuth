package com.leandrosps.JwtAuth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class User {

    private String id;
    private String username;
    private String email;
    private Password password;
    private int age;

    public record UserInput(String username, String email, String password, int age) {
    }

    public static User create(UserInput input) {
        final String id = UUID.randomUUID().toString();
        return new User(id, input.username(), input.email(), new Password(input.password()), input.age());
    }

    public static User rebuild(UserInput input) {
        final String id = UUID.randomUUID().toString();
        return new User(id, input.username(), input.email(), new Password(input.password(), 11), input.age());
    }
}
