package com.billennium.petproject.service.impl;

import com.billennium.petproject.repository.UserRepository;
import com.billennium.petproject.model.UserEntity;
import com.billennium.petproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
