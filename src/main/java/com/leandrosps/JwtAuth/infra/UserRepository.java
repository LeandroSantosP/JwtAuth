package com.leandrosps.JwtAuth.infra;

import com.leandrosps.JwtAuth.domain.User;

import java.util.Optional;

public interface UserRepository {
    void persist(User user);

    User getByEmail(String email);

    User getById(String id);

    Optional<User> getByEmailOptional(String email);
}
