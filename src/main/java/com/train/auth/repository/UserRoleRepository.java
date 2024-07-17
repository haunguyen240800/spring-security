package com.train.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.auth.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

}
