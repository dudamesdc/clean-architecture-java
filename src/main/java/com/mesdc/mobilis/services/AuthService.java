package com.mesdc.mobilis.services;

import com.mesdc.mobilis.infra.security.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mesdc.mobilis.dto.RegisterRequestDTO;
import com.mesdc.mobilis.dto.LoginRequestDTO;
import com.mesdc.mobilis.dto.ResponseDTO;
import com.mesdc.mobilis.domain.user.User;
import com.mesdc.mobilis.repositories.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public ResponseDTO login(LoginRequestDTO body) {
        User user = repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(body.password(), user.getPassword())) {
            throw new RuntimeException("Invalid credentiasls");
        }

        String token = tokenService.generateToken(user);
        return new ResponseDTO(user.getName(), token);
    }

    public ResponseDTO register(RegisterRequestDTO body) {
        Optional<User> existing = repository.findByEmail(body.email());
        if (existing.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(body.password()));
        newUser.setEmail(body.email());
        newUser.setName(body.name());
        repository.save(newUser);

        String token = tokenService.generateToken(newUser);
        return new ResponseDTO(newUser.getName(), token);

    }
}
