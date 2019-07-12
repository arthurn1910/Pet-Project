package com.billennium.petproject.security.jwt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {

    private String accessToken;

    private String email;

    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String accessToken, String email, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = accessToken;
        this.email = email;
        this.authorities = authorities;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}