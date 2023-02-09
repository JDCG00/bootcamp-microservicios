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

    //Recoge un usuario indicado por id
    @GetMapping("/users/{id}")
    public Optional<Usuario> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    //Añade un usuario con los parametros dados (se ponen estos en el body), por ejemplo:
    //{
    //    "name": "Lolo",
    //    "birthdate": "2002-07-09"
    //}
    //También emite un código de estado creado(201)
    @PostMapping("/users")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario){
        if (usuario.getName() == null && usuario.getbirthdate() == null){
            throw new IllegalArgumentException("Se debe introducir nombre y fecha de nacimiento del usuario.");
        } else if (usuario.getName() == null) {
            throw new IllegalArgumentException("Se debe introducir el nombre de usuario.");
        }else if (usuario.getbirthdate() == null){
            throw new IllegalArgumentException("Se debe introducir la fecha de nacimiento del usuario.");
        }
        return new ResponseEntity<>(userService.saveUser(usuario), HttpStatus.CREATED);
    }
    //Actualiza un usuario con los parametros dados (se necesita tambíen el id en el body para actualizar el usuario),
    // por ejemplo:
    //{
    //    "id": 3,
    //    "name": "Patricio",
    //    "birthdate": "2002-07-09"
    //}
    @PutMapping("/users")
    public Usuario updateUser(@RequestBody Usuario usuario){
        return userService.saveUser(usuario);
    }
    //Elimina un usuario según el id que tenga
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

}
