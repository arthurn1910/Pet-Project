package com.billennium.petproject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.billennium.petproject.model.UserEntity;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserEntity getUserByEmail(String email);

    List<UserEntity> getUsersByRole(String roleName);

    void removeUser(Long id);
}