package com.leandrosps.JwtAuth.infra.controlles;

import com.leandrosps.JwtAuth.services.AuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/authentication")
    private String authenticate(Authentication authentication) {
        return this.authenticationService.authentication(authentication);
    }
}
