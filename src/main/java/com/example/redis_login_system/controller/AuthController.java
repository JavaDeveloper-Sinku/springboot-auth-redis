package com.example.redis_login_system.controller;


import com.example.redis_login_system.dto.LoginRequest;
import com.example.redis_login_system.entity.User;
import com.example.redis_login_system.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController (AuthService authService){
        this.authService = authService;

    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request){
        return authService.login(request.getEmail(), request.getPassword());
    }
}
