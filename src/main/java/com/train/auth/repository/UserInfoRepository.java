package com.train.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.auth.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

}
