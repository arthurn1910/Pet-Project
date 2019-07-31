package com.billennium.petproject.repository;

import com.billennium.petproject.model.RoleEntity;
import com.billennium.petproject.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    List<UserEntity> findAllByRoles(RoleEntity role);
}
