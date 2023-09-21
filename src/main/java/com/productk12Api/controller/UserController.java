package com.productk12Api.controller;

import com.productk12Api.model.User;
import com.productk12Api.model.UserDto;
import com.productk12Api.security.JwtFilter;
import com.productk12Api.security.JwtProvider;
import com.productk12Api.service.SignInService;
import com.productk12Api.service.User12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    private User12Service user12Service;
    @Autowired
    private SignInService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto user) {
        User user1 = new User();
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        return user12Service.save(user1, user.getRid());

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto user) {
       return service.login(user);
    }


}
