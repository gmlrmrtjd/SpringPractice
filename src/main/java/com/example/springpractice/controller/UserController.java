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
@RestController // JSON으로 반환하는 컨트롤러(각 메소드마다 @ResponseBody 어노테이션을 이 어노테이션 혀나로 해결)
public class UserController {

    private final UserService userService;

    @GetMapping // HTTP Method Get 요청 api
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
