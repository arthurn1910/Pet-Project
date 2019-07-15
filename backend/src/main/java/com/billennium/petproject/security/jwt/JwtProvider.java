package com.billennium.petproject.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.billennium.petproject.model.UserEntity;
import com.billennium.petproject.model.UserPrinciple;
import com.billennium.petproject.service.UserService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${app.jwtSecretKey}")
    private String jwtSecretKey;

    @Value("${app.jwtExpirationTime}")
    private int jwtExpirationTime;

    private final UserService userService;

    public JwtProvider(UserService userService) {
        this.userService = userService;
    }

    public String generateJwtToken(Authentication authentication) {

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        UserEntity user = userService.getUserByEmail(userPrinciple.getEmail());

        return Jwts.builder()
            .setSubject((user.getEmail()))
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationTime * 1000))
            .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
            .compact();
    }

    boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty");
        }

        return false;
    }

    String getEmailFromJwtToken(String token) {
        return Jwts.parser()
            .setSigningKey(jwtSecretKey)
            .parseClaimsJws(token)
            .getBody().getSubject();
    }
}