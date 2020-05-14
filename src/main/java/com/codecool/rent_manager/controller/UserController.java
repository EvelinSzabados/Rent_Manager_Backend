package com.codecool.rent_manager.controller;

import com.codecool.rent_manager.model.UserCredentials;
import com.codecool.rent_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserCredentials appUser) {
        userService.register(appUser.getUsername(),appUser.getPassword());
        return appUser.getUsername();
    }
}
