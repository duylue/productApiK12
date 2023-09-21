package com.productk12Api.service;

import com.productk12Api.model.UserDto;
import org.springframework.http.ResponseEntity;

public interface SignInService {
    ResponseEntity<?> login(UserDto dto);

}
