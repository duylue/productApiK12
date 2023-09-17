package com.productk12Api.service.impl;

import com.productk12Api.base.BaseResponse;
import com.productk12Api.jwt.JwtProvider;
import com.productk12Api.model.Role;
import com.productk12Api.model.User;
import com.productk12Api.repository.RoleRepository;
import com.productk12Api.repository.UserRepository;
import com.productk12Api.service.User12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends BaseResponse implements User12Service {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<?> save(User user, int[] rid) {
        List<Role> roles = new ArrayList<>();
        for (int id : rid) {
            Optional<Role> optionalRole = roleRepository.findById(id);
            if (optionalRole.isEmpty()) {
                throw new RuntimeException("rid invalid");
            }
            roles.add(optionalRole.get());
        }
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return getResponseEntity(repository.save(user));
    }


    @Override
    public ResponseEntity<?> findByUsername(String username) {
        return null;
    }

    @Override
    public User findByUsername12(String username) {
        return repository.findByUsername(username);
    }
}
