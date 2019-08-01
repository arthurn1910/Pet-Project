package com.billennium.petproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.billennium.petproject.model.UserEntity;
import com.billennium.petproject.service.UserService;

import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @GetMapping("email/{email}")
    public ResponseEntity userByEmail(@PathVariable String email) {
        UserEntity user = userService.getUserByEmail(email);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping("operators")
    public ResponseEntity getOperators() {
        List<UserEntity> users = userService.getUsersByRole("OPERATOR");
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity removeUser(@PathVariable String id) {
        userService.removeUser(parseLong(id));
        return new ResponseEntity(HttpStatus.OK);
    }
}
