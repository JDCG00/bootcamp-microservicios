package com.microservicios.bootcampmicroservicios.service;


import com.microservicios.bootcampmicroservicios.model.Usuario;
import com.microservicios.bootcampmicroservicios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Busca el usuario según el id
    public Optional<Usuario> getUserById(Long id){
        return userRepository.findById(id);
    }
    //Guarda el usuario
    public Usuario saveUser(Usuario usuario){
        return userRepository.save(usuario);
    }
    //Elimina el usuario según el id
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
