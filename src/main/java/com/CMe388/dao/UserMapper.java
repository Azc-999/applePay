package com.CMe388.dao;

import com.CMe388.pojo.User;

import java.util.List;

public interface UserMapper {
    User login(User user);

    Integer register(User user);

    User findUserByName(String username);

    User findOrderWithUser(Integer userId);

    List<User> findAllUser();
}