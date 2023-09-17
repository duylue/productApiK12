package com.productk12Api.service;

import com.productk12Api.model.User;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> login(User user);
}
