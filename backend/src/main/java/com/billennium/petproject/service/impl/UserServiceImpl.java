package com.billennium.petproject.service.impl;

import com.billennium.petproject.model.RoleEntity;
import com.billennium.petproject.repository.RoleRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.billennium.petproject.model.UserEntity;
import com.billennium.petproject.model.UserPrinciple;
import com.billennium.petproject.repository.UserRepository;
import com.billennium.petproject.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        UserEntity user = userRepository.findByEmail(email);
        return UserPrinciple.build(user);
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserEntity> getUsersByRole(String roleName) {
        RoleEntity role = roleRepository.findRoleByName(roleName);
        return userRepository.findAllByRoles(role);
    }
}
