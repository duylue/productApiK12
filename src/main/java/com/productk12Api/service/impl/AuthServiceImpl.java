package com.productk12Api.service.impl;

import com.productk12Api.base.BaseResponse;
import com.productk12Api.jwt.JwtProvider;
import com.productk12Api.model.User;
import com.productk12Api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl extends BaseResponse implements AuthService {
    @Autowired
    private JwtProvider provider;
    @Autowired
    private AuthenticationManager manager;

    @Override
    public ResponseEntity<?> login(User user) {
        Authentication authentication =
                manager
                .authenticate
                        (new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token  = provider.getToken(authentication);
        return getResponseEntity(token);
    }
}
