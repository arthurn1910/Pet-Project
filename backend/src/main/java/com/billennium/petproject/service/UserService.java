package com.billennium.petproject.service;

import com.billennium.petproject.model.UserEntity;

public interface UserService {
    UserEntity getUserByEmail(String email);
}
