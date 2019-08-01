package com.billennium.petproject.service.impl;

import com.billennium.petproject.model.TokenEntity;
import com.billennium.petproject.repository.TokenRepository;
import com.billennium.petproject.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class TokenServiceImpl implements TokenService {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    private final TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public List<TokenEntity> getAllTokens() {
        return newArrayList(tokenRepository.findAll());
    }

    @Override
    public TokenEntity getTokenById(long tokenId) {
        return tokenRepository.findById(tokenId)
                .orElseThrow(() -> new IllegalStateException("No token found for id: " + tokenId));
    }

    @Override
    public boolean addToken(TokenEntity token) {
        try {
            tokenRepository.save(token);
        } catch (DataAccessException exception) {
            log.error("Token save exception. Details: " + exception.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void updateToken(TokenEntity token) {
        try {
            tokenRepository.save(token);
        } catch (DataAccessException exception) {
            log.error("Token update exception. Details: " + exception.getMessage());
        }
    }

    @Override
    public void deleteToken(long tokenId) {
        tokenRepository.delete(getTokenById(tokenId));
    }
}
