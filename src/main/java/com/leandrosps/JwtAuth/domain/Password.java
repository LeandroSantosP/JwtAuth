package com.leandrosps.JwtAuth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


public class Password {

    @Getter
    private final String value;

    private final  PasswordEncoder passwordEncoder;

    @Getter
    private int salt = 11;

    public Password(String value, int salt) {
        this.passwordEncoder = new BCryptPasswordEncoder(salt);
        this.value = value;
        this.salt = salt;
    }

    public Password(String value) {
        this.passwordEncoder = new BCryptPasswordEncoder(salt);
        this.value = passwordEncoder.encode(value);
    }

    public boolean isValid(String rawPass){
        return passwordEncoder.matches(rawPass, this.value);
    }

}
