package com.productk12Api.security;

import com.productk12Api.model.User;
import com.productk12Api.service.User12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthDetailService implements UserDetailsService {
    @Autowired
    private User12Service service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.getByUsername(username);
        if (user == null){
            throw new  RuntimeException("UsernameNotFoundException");
        }
        return new UserAuth(user);
    }
}
