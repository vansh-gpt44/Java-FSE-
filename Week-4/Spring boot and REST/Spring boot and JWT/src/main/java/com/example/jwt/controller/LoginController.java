package com.example.jwt.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.jwt.service.JwtUtil;

@RestController
public class LoginController {

 @Autowired JwtUtil jwtUtil;

 @PostMapping("/login")
 public String login(@RequestParam String username,
                     @RequestParam String password){
  if(username.equals("admin") && password.equals("password"))
    return jwtUtil.generateToken(username);
  return "Invalid User";
 }

 @GetMapping("/api/test")
 public String test(){
  return "JWT Protected Resource";
 }
}