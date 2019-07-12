package com.billennium.petproject.controller;

import com.billennium.petproject.model.UserEntity;
import com.billennium.petproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> userByEmail(@PathVariable String email) {
        UserEntity user = userService.getUserByEmail(email);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
