package com.billennium.petproject.dao;

import com.billennium.petproject.model.UserEntity;

public interface UserDao extends Dao<UserEntity> {
    UserEntity findUserByEmail(String email);
}
