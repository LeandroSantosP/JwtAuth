package com.leandrosps.JwtAuth.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String authentication(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }

}
