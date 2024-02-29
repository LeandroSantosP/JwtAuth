package com.leandrosps.JwtAuth.infra.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJDBC extends CrudRepository<UserJDBC, String> {
    Optional<UserJDBC> findByEmail(String email);
}
