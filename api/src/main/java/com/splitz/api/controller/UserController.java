package com.splitz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.splitz.api.dto.UserDto;
import com.splitz.api.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;
  
    // TODO: Need to implement login process

    // Show user dashboard
    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }
}
