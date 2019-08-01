package com.billennium.petproject.service;

import com.billennium.petproject.model.TestEntity;

import java.util.List;

public interface TestService {
    List<TestEntity> getAllTests();

    TestEntity getTestById(long testId);

    boolean addTest(TestEntity test);

    void updateTest(TestEntity test);

    void deleteTest(long testId);

    List<TestEntity> getTestsByStatus(String status);

    TestEntity getTestsByCandidateId(long candidateId);
}