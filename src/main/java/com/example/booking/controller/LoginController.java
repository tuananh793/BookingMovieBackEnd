package com.example.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.booking.entity.User;
import com.example.booking.service.UserService;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public User checkLogin(@RequestParam String userName, @RequestParam String passWord) {
        User user = userService.findByUserNameAndPassWord(userName, passWord);
        return user;
    }

    @PostMapping("/register")
    public User checkRegister(@RequestParam String userName, @RequestParam String passWord,
            @RequestParam String rePassWord) {
        if (!passWord.equals(rePassWord))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mật khẩu không khớp");
        User user = userService.findByUserName(userName);
        if (user != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tài khoản đã có người sử dụng");
        User nUser = new User();
        nUser.setUserName(userName);
        nUser.setPassWord(passWord);

        return userService.saveUser(nUser);
    }

}
