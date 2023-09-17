package com.productk12Api.jwt;

import com.productk12Api.service.impl.UserDetail12;
import io.jsonwebtoken.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final String sKey = "duy333";
    public String getToken(Authentication authentication){
        Date date = new Date();
        Date dateEx = new Date(date.getTime()+360*100000);
        UserDetail12 userDetail12 = (UserDetail12) authentication.getPrincipal();
        return Jwts.builder().setSubject(userDetail12.getUsername())
                .setIssuedAt(date)
                .setExpiration(dateEx)
                .signWith(SignatureAlgorithm.HS512,sKey)
                .compact();

    }
    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(sKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Expire Jwt token");

        }catch (UnsupportedJwtException e) {
            throw new RuntimeException("Unsupported Jwt token");

        }catch (MalformedJwtException e) {
            throw new RuntimeException("Invalid format token");

        }catch (SignatureException e) {
            throw new RuntimeException("Invalid Jwt signature");

        }catch (IllegalArgumentException e) {
            throw new RuntimeException("jwt claims String is empty");

        }
    }
    public String getUsernameByToken(String token){
        try {

            String username = Jwts.parser().setSigningKey(sKey).parseClaimsJws(token).getBody().getSubject();
            return username;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }

    }

}
