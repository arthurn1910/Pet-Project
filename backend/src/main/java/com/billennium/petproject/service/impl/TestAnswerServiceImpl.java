package com.billennium.petproject.service.impl;

import com.billennium.petproject.model.TestAnswerEntity;
import com.billennium.petproject.repository.TestAnswerRepository;
import com.billennium.petproject.service.TestAnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class TestAnswerServiceImpl implements TestAnswerService {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    private final TestAnswerRepository testAnswerRepository;

    public TestAnswerServiceImpl(TestAnswerRepository testAnswerRepository) {
        this.testAnswerRepository = testAnswerRepository;
    }

    @Override
    public List<TestAnswerEntity> getAllTestAnswers() {
        return newArrayList(testAnswerRepository.findAll());
    }

    @Override
    public TestAnswerEntity getTestAnswerById(long testAnswerId) {
        return testAnswerRepository.findById(testAnswerId)
                .orElseThrow(() -> new IllegalStateException("No test answer found for id: " + testAnswerId));
    }

    @Override
    public boolean addTestAnswer(TestAnswerEntity testAnswer) {
        try {
            testAnswerRepository.save(testAnswer);
        } catch (DataAccessException exception) {
            log.error("Answer save exception. Details: " + exception.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void updateTestAnswer(TestAnswerEntity testAnswer) {
        try {
            testAnswerRepository.save(testAnswer);
        } catch (DataAccessException exception) {
            log.error("Answer update exception. Details: " + exception.getMessage());
        }
    }

    @Override
    public void deleteTestAnswer(long testAnswerId) {
        testAnswerRepository.delete(getTestAnswerById(testAnswerId));
    }

    @Override
    public List<TestAnswerEntity> getTestAnswersByContent(String content) {
        return testAnswerRepository.findByContentContaining(content);
    }

    @Override
    public List<TestAnswerEntity> getTestAnswersByTestId(long testId) {
        return testAnswerRepository.findByTestId(testId);
    }

    @Override
    public List<TestAnswerEntity> getTestAnswersByAnswerId(long answerId) {
        return testAnswerRepository.findByAnswerId(answerId);
    }
}
