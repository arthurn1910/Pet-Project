package com.billennium.petproject.controller;

import com.billennium.petproject.model.LoginForm;
import com.billennium.petproject.model.RegisterForm;
import com.billennium.petproject.security.jwt.JwtProvider;
import com.billennium.petproject.security.jwt.JwtResponse;
import com.billennium.petproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    private final UserService userService;

    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authenticationManager, JwtProvider jwtProvider, UserService userService, PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.userService = userService;
        this.encoder = encoder;
    }

    @PostMapping("login")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("register")
    public ResponseEntity registerOperator(@Valid @RequestBody RegisterForm registerForm) {
        userService.createUser(registerForm, encoder.encode(registerForm.getPassword()), "OPERATOR");
        return ResponseEntity.ok(HttpStatus.OK);
    }
}