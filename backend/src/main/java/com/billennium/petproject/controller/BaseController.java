package com.billennium.petproject.controller;

import com.billennium.petproject.model.BaseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;

public class BaseController {

    protected ResponseEntity<Void> validateCreationAndCreateResponse(boolean entityPersisted, BaseEntity entity) {
        if (!entityPersisted) {
            return new ResponseEntity<Void>(CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(UriComponentsBuilder.newInstance().path("id/{id}").buildAndExpand(entity.getId()).toUri());
        return new ResponseEntity<Void>(headers, CREATED);
    }
}
