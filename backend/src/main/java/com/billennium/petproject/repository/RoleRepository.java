package com.billennium.petproject.repository;

import com.billennium.petproject.model.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    RoleEntity findRoleByName(String name);
}
