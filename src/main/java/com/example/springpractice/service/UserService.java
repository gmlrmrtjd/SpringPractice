package com.example.springpractice.service;

import com.example.springpractice.domain.User;
import com.example.springpractice.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;

    public List<User> getUserList() {
        userMapper.insertUser();
        return userMapper.getUserList();
    }
}
