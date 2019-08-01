package com.billennium.petproject.repository;

import com.billennium.petproject.model.TokenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<TokenEntity, Long> {
}
