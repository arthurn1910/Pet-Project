package com.billennium.petproject.security.jwt;

import java.util.Date;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.billennium.petproject.model.UserPrinciple;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    private String jwtSecretKey = "Ra7$3GP1).$5a@for4LpW&/ZWAt>i8UJC9X%b}lpD:GtYMcEt?PcMkh%,PLRL7$";

    public String generateJwtToken(Authentication authentication) {

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        final String authorities = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));

        int jwtExpirationTime = 86400;
        return Jwts.builder()
            .setSubject(userPrinciple.getEmail())
            .claim("autorities", authorities)
            .claim("name", userPrinciple.getName())
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