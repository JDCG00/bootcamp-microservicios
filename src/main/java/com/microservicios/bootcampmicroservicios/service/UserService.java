package com.microservicios.bootcampmicroservicios.service;

import com.microservicios.bootcampmicroservicios.model.User;
import com.microservicios.bootcampmicroservicios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id){
        return userRepository.getReferenceById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

}
