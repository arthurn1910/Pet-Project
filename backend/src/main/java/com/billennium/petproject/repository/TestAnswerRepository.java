package com.billennium.petproject.repository;

import com.billennium.petproject.model.TestAnswerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestAnswerRepository extends CrudRepository<TestAnswerEntity, Long> {

    List<TestAnswerEntity> findByContentContaining(String content);

    List<TestAnswerEntity> findByTestId(long id);
    
    List<TestAnswerEntity> findByAnswerId(long id);
}
