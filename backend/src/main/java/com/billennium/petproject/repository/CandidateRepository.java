package com.billennium.petproject.repository;

import com.billennium.petproject.model.CandidateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends CrudRepository<CandidateEntity, Long> {

    List<CandidateEntity> findByEmailContaining(String email);

    List<CandidateEntity> findByFullNameContaining(String fullName);
}
