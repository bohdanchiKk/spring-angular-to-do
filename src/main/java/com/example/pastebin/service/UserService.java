package com.example.pastebin.service;

import com.example.pastebin.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    void createUser(String name);

    User findUserById(Long id);

    Optional<User> getUser(Long id);
}
