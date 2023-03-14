package com.example.springpractice.mapper;

import com.example.springpractice.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUserList();

    void insertUser();
}
