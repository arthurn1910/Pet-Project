package com.billennium.petproject.service;

import com.billennium.petproject.model.TokenEntity;

import java.util.List;

public interface TokenService {
    List<TokenEntity> getAllTokens();

    TokenEntity getTokenById(long tokenId);

    boolean addToken(TokenEntity token);

    void updateToken(TokenEntity token);

    void deleteToken(long tokenId);
}