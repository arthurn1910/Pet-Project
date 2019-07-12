package com.billennium.petproject.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.billennium.petproject.model.UserEntity;
import com.billennium.petproject.model.UserPrinciple;
import com.billennium.petproject.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        UserEntity user = userRepository.findByEmail(email);
        return UserPrinciple.build(user);
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
