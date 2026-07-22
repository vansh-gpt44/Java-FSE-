package com.example.jwt.service;

import java.util.*;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

@Component
public class JwtUtil {
 private String secret="mysecretkey";

 public String generateToken(String username){
  return Jwts.builder()
   .setSubject(username)
   .setIssuedAt(new Date())
   .setExpiration(new Date(System.currentTimeMillis()+3600000))
   .signWith(SignatureAlgorithm.HS256, secret)
   .compact();
 }
}