package com.example.springpractice.controller;

import com.example.springpractice.domain.User;
import com.example.springpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("user")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
