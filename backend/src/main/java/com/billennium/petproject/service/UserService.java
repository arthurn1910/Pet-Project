package com.billennium.petproject.service;

import com.billennium.petproject.model.RegisterForm;
import com.billennium.petproject.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserEntity getUserByEmail(String email);

    List<UserEntity> getUsersByRole(String roleName);

    void removeUser(Long id);

    void createUser(RegisterForm registerForm, String password, String roleName);
}