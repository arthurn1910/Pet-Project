package com.billennium.petproject.service;

import com.billennium.petproject.model.TestAnswerEntity;

import java.util.List;

public interface TestAnswerService {

    List<TestAnswerEntity> getAllTestAnswers();

    TestAnswerEntity getTestAnswerById(long testAnswerId);

    boolean addTestAnswer(TestAnswerEntity answer);

    void updateTestAnswer(TestAnswerEntity answer);

    void deleteTestAnswer(long answerId);

    List<TestAnswerEntity> getTestAnswersByContent(String content);

    List<TestAnswerEntity> getTestAnswersByTestId(long testId);

    List<TestAnswerEntity> getTestAnswersByAnswerId(long answerId);
}