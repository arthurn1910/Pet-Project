package com.billennium.petproject.controller;

import com.billennium.petproject.model.TokenEntity;
import com.billennium.petproject.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("token")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TokenController extends BaseController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("list")
    public ResponseEntity<List<TokenEntity>> getAllTokens() {
        List<TokenEntity> list = tokenService.getAllTokens();
        return new ResponseEntity<List<TokenEntity>>(list, OK);
    }

    @PostMapping("save")
    public ResponseEntity<Void> addToken(@RequestBody TokenEntity token) {
        boolean created = tokenService.addToken(token);
        return validateCreationAndCreateResponse(created, token);
    }

    @PutMapping("update")
    public ResponseEntity<TokenEntity> updateToken(@RequestBody TokenEntity token) {
        tokenService.updateToken(token);
        return new ResponseEntity<TokenEntity>(token, OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteToken(@PathVariable("id") Integer id) {
        tokenService.deleteToken(id);
        return new ResponseEntity<Void>(NO_CONTENT);
    }
}
