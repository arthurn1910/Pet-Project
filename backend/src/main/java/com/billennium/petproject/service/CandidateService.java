package com.billennium.petproject.service;

import com.billennium.petproject.model.CandidateEntity;

import java.util.List;

public interface CandidateService {
    List<CandidateEntity> getAllCandidates();

    CandidateEntity getCandidateById(long candidateId);

    boolean addCandidate(CandidateEntity candidate);

    void updateCandidate(CandidateEntity candidate);

    void deleteCandidate(long candidateId);

    List<CandidateEntity> getCandidatesByEmail(String email);

    List<CandidateEntity> getCandidatesByName(String name);
}