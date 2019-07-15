package com.billennium.petproject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.billennium.petproject.model.UserEntity;

public interface UserService extends UserDetailsService {
    UserEntity getUserByEmail(String email);
}