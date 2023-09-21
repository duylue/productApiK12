package com.productk12Api.service.impl;

import com.productk12Api.base.BaseResponse;
import com.productk12Api.model.UserDto;
import com.productk12Api.security.JwtProvider;
import com.productk12Api.service.SignInService;
import com.productk12Api.service.User12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl extends BaseResponse implements SignInService {
    @Autowired
    private JwtProvider provider;
    @Autowired
    private AuthenticationManager authenticationManager;
    public ResponseEntity<?> login(UserDto dto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername()
                        , dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = provider.createToken(authentication);
        return getResponseEntity(token);
    }

}
