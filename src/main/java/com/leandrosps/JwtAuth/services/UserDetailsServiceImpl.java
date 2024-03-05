package com.leandrosps.JwtAuth.services;

import com.leandrosps.JwtAuth.domain.User;
import com.leandrosps.JwtAuth.infra.UserRepository;
import com.leandrosps.JwtAuth.infra.config.UserDetailsAuthentication;
import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> byEmail = this.userRepository
                .getByEmailOptional(email);
        if (byEmail.isEmpty()) {
            throw new BadCredentialsException("Invalid Credentials");
        }
        return new UserDetailsAuthentication(byEmail.get());
    }
}
