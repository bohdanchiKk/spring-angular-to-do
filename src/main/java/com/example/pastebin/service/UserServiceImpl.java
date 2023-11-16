package com.example.pastebin.service;

import com.example.pastebin.entity.User;
import com.example.pastebin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(String name) {
        userRepository.createUser(name);
    }
    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }




}
