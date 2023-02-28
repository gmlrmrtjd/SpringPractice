package com.example.springpractice.service;

import com.example.springpractice.domain.User;
import com.example.springpractice.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
