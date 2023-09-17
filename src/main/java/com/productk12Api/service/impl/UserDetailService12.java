package com.productk12Api.service.impl;

import com.productk12Api.model.User;
import com.productk12Api.service.User12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService12 implements UserDetailsService {
    @Autowired
    User12Service service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.findByUsername12(username);
        if (user==null){
            throw new RuntimeException("Tai khoan hoac mat khau khong dung");

        }
        return new UserDetail12(user);
    }
}
