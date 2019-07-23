package com.billennium.petproject.service.impl;

import com.billennium.petproject.model.CandidateEntity;
import com.billennium.petproject.repository.CandidateRepository;
import com.billennium.petproject.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class CandidateServiceImpl implements CandidateService {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    private final CandidateRepository candidateRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<CandidateEntity> getAllCandidates() {
        return newArrayList(candidateRepository.findAll());
    }

    @Override
    public CandidateEntity getCandidateById(long candidateId) {
        return candidateRepository.findById(candidateId)
                .orElseThrow(() -> new IllegalStateException("No candidate found for id: " + candidateId));
    }

    @Override
    public boolean addCandidate(CandidateEntity candidate) {
        try {
            candidateRepository.save(candidate);
        } catch (DataAccessException exception) {
            log.error("Candidate save exception. Details: " + exception.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void updateCandidate(CandidateEntity candidate) {
        try {
            candidateRepository.save(candidate);
        } catch (DataAccessException exception) {
            log.error("Candidate update exception. Details: " + exception.getMessage());
        }
    }

    @Override
    public void deleteCandidate(long candidateId) {
        candidateRepository.delete(getCandidateById(candidateId));
    }

    @Override
    public List<CandidateEntity> getCandidatesByEmail(String email) {
        return candidateRepository.findByEmailContaining(email);
    }

    @Override
    public List<CandidateEntity> getCandidatesByName(String name) {
        return candidateRepository.findByFullNameContaining(name);
    }

}
