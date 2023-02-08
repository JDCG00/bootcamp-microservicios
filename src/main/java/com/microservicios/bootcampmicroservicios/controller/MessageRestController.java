package com.microservicios.bootcampmicroservicios.controller;

import com.microservicios.bootcampmicroservicios.message.Message;
import com.microservicios.bootcampmicroservicios.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {
    @Autowired
    private MessageServiceImpl messageService;

    @GetMapping("/api/v1/{message}")
    public Message printMessage(@PathVariable("message") String message) {
        return new Message(messageService.getMessage());
    }

}
