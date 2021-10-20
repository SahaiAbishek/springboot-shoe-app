package com.abhi.shoes.dao;

import com.abhi.shoes.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    public UserInfo findByEmail(String email);
}
