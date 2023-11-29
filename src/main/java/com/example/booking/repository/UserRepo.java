package com.example.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.User;

@Repository

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserNameAndPassWord(String userName, String passWord);

    User findByUserName(String userName);

}
