package com.billennium.petproject.repository;

import com.billennium.petproject.model.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<TestEntity, Long> {

    List<TestEntity> findByStatus(String status);

    TestEntity findByCandidateId(long id);
}
