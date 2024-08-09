package com.AlpDereli.StajProjesi.controller;

import com.AlpDereli.StajProjesi.security.JWTutil;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authenticate")
public class AuthController {


    private JWTutil jwtUtil;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestParam String username, @RequestParam String password) {
        // Authenticate user (check username and password)
        // If successful:
        String token = jwtUtil.generateToken(username);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @Getter
        public record AuthenticationResponse(String jwt) {
    }
}
