package com.billennium.petproject.service.impl;

import com.billennium.petproject.dao.UserDao;
import com.billennium.petproject.model.UserEntity;
import com.billennium.petproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
}
