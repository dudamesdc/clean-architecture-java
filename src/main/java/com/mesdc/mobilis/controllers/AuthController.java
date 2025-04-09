package com.mesdc.mobilis.controllers;

import com.mesdc.mobilis.dto.LoginRequestDTO;
import com.mesdc.mobilis.dto.RegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import com.mesdc.mobilis.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        return ResponseEntity.ok(authService.login(body));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        return ResponseEntity.ok(authService.register(body));
    }
}