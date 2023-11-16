package com.example.pastebin.controller;

import com.example.pastebin.entity.Note;
import com.example.pastebin.entity.User;
import com.example.pastebin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public void createUser(@RequestParam String name){
        userService.createUser(name);
    }
    @GetMapping("/get/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

}
