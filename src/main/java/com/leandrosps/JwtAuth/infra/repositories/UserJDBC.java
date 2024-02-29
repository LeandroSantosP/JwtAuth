package com.leandrosps.JwtAuth.infra.repositories;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Getter
@Table("USERS")
public class UserJDBC {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private int age;

}
