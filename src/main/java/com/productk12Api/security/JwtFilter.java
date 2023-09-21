package com.productk12Api.security;

import com.productk12Api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.IllegalFormatCodePointException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    JwtProvider provider;
    @Autowired
    UserAuthDetailService authDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token!= null){
            token = token.replace("Bearer", "");
            if (provider.validateToken(token)) {
                String username = provider.getUsername(token);
                UserDetails userDetails = authDetailService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken autk =
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                autk.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(autk);
            }
        }

        filterChain.doFilter(request,response);
    }
}
