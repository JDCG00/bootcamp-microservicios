package com.microservicios.bootcampmicroservicios.controller;


import com.microservicios.bootcampmicroservicios.model.Usuario;
import com.microservicios.bootcampmicroservicios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public Optional<Usuario> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
    @PostMapping("/users")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario){
        userService.saveUser(usuario);
        return ResponseEntity.created(URI.create("/users")).build();
    }
    @PutMapping("/users")
    public Usuario updateUser(@RequestBody Usuario usuario){
        return userService.saveUser(usuario);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

}
