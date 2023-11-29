package com.example.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking.entity.User;
import com.example.booking.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User findByUserNameAndPassWord(String userName, String passWord) {
        User user = userRepo.findByUserNameAndPassWord(userName, passWord);
        return user;
    }

    public User findByUserName(String userName) {
        User user = userRepo.findByUserName(userName);
        return user;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User findByid(int id) {
        return userRepo.findById(id).orElse(null);
    }
}
