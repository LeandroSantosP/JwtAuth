package com.leandrosps.JwtAuth.infra.controlles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {
    @GetMapping
    public ResponseEntity<String> getContent() {
        return ResponseEntity.status(201).body("Message Private!!: ");
    }
}
