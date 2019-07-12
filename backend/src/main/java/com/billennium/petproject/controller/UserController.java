package com.billennium.petproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billennium.petproject.model.UserEntity;
import com.billennium.petproject.service.impl.UserServiceImpl;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    private final UserServiceImpl userService;

    @GetMapping("email/{email}")
    public ResponseEntity<UserEntity> userByEmail(@PathVariable String email) {
        UserEntity user = userService.getUserByEmail(email);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
