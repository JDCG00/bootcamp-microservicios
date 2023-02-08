package com.microservicios.bootcampmicroservicios.controller;

import com.microservicios.bootcampmicroservicios.model.User;
import com.microservicios.bootcampmicroservicios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
