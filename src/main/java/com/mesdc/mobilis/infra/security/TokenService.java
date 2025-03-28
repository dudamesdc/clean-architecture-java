package com.mesdc.mobilis.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.mesdc.mobilis.domain.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Instant;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;

@Service
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;
   public String generateToken(User user){
    try{
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token=JWT.create()
        .withSubject(user.getEmail())
        .withExpiresAt(this.generateExpirationDate())
        .sign(algorithm);
        return token;
    }catch(JWTCreationException exception){
        throw new RuntimeException("Error while authenticating");
    }
   } 

   private Instant generateExpirationDate(){
    return LocalDateTime.now().plusHours(01).toInstant(ZoneOffset.of("-03:00"));
   }
}
