package com.billennium.petproject.service.impl;

import com.billennium.petproject.model.TestEntity;
import com.billennium.petproject.repository.TestRepository;
import com.billennium.petproject.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class TestServiceImpl implements TestService {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<TestEntity> getAllTests() {
        return newArrayList(testRepository.findAll());
    }

    @Override
    public TestEntity getTestById(long testId) {
        return testRepository.findById(testId)
                .orElseThrow(() -> new IllegalStateException("No test found for id: " + testId));
    }

    @Override
    public boolean addTest(TestEntity test) {
        try {
            testRepository.save(test);
        } catch (DataAccessException exception) {
            log.error("Test save exception. Details: " + exception.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void updateTest(TestEntity test) {
        try {
            testRepository.save(test);
        } catch (DataAccessException exception) {
            log.error("Test update exception. Details: " + exception.getMessage());
        }
    }

    @Override
    public void deleteTest(long testId) {
        testRepository.delete(getTestById(testId));
    }

    @Override
    public List<TestEntity> getTestsByStatus(String status) {
        return testRepository.findByStatus(status);
    }

    @Override
    public TestEntity getTestsByCandidateId(long candidateId) {
        return testRepository.findByCandidateId(candidateId);
    }
}
