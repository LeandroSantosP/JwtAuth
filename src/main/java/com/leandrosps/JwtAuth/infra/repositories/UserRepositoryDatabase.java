package com.leandrosps.JwtAuth.infra.repositories;

import com.leandrosps.JwtAuth.domain.Password;
import com.leandrosps.JwtAuth.domain.User;
import com.leandrosps.JwtAuth.infra.UserRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Primary
@Repository
public class UserRepositoryDatabase implements UserRepository {

    public UserRepositoryJDBC userRepositortyJDBC;

    public UserRepositoryDatabase(UserRepositoryJDBC userRepositortyJDBC) {
        this.userRepositortyJDBC = userRepositortyJDBC;
    }

    @Override
    public void persist(User user) {
        this.userRepositortyJDBC.save(new UserJDBC(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword().getValue(),
                user.getAge()));
    }

    @Override
    public User getByEmail(String email) {
        Optional<UserJDBC> userJDBCOp = this.userRepositortyJDBC.findByEmail(email);
        if (userJDBCOp.isEmpty()) {
            throw new BadCredentialsException("User not found!");
        }
        UserJDBC userJDBC = userJDBCOp.get();
        return new User(
                userJDBC.getId(),
                userJDBC.getUsername(),
                userJDBC.getEmail(),
                new Password(userJDBC.getPassword()),
                userJDBC.getAge());
    }

    @Override
    public User getById(String id) {
        Optional<UserJDBC> userJDBCOp = this.userRepositortyJDBC.findById(id);
        if (userJDBCOp.isEmpty()) {
            throw new BadCredentialsException("User not found!");
        }
        UserJDBC userJDBC = userJDBCOp.get();
        return new User(
                userJDBC.getId(),
                userJDBC.getUsername(),
                userJDBC.getEmail(),
                new Password(userJDBC.getPassword(), 11),
                userJDBC.getAge());
    }

    @Override
    public Optional<User> getByEmailOptional(String email) {
        Optional<UserJDBC> userJDBCOp = this.userRepositortyJDBC.findByEmail(email);
        if (userJDBCOp.isEmpty()) {
            return Optional.empty();
        }
        UserJDBC userJDBC = userJDBCOp.get();
        return Optional.of(
                new User(
                        userJDBC.getId(),
                        userJDBC.getUsername(),
                        userJDBC.getEmail(),
                        new Password(userJDBC.getPassword(), 11),
                        userJDBC.getAge()));
    }
}
