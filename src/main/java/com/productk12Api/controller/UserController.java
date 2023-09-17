package com.productk12Api.controller;

import com.productk12Api.model.User;
import com.productk12Api.model.UserDto;
import com.productk12Api.service.AuthService;
import com.productk12Api.service.User12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("isAuthenticated()")
public class UserController {
    @Autowired
    private User12Service user12Service;
    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> register(@RequestBody UserDto user) {
        User user1 = new User();
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        return user12Service.save(user1, user.getRid());

    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?>login(@RequestBody User user){

        return authService.login(user);
    }
}
