package com.CMe388.service;

import com.CMe388.pojo.User;

import java.util.List;

public interface UserService {
    User login(User user);

    Integer register(User user);

    User findUserByName(String username);

    List<User> findAllUser();
}
