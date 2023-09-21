package com.productk12Api.security;

import com.productk12Api.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final String secretKey = "javak12";

    public String createToken(Authentication authentication) {
        UserAuth userDetails = (UserAuth) authentication.getPrincipal();
        String token = Jwts.builder().
                setExpiration(new Date(new Date().getTime() + 100000))
                .setIssuedAt(new Date())
                .setSubject(userDetails.getUsername())
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return token;

    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
    public String getUsername(String token){
        return  Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }


}
