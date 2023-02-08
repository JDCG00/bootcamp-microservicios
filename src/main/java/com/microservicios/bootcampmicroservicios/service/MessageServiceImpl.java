package com.microservicios.bootcampmicroservicios.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class MessageServiceImpl implements IMessageService {
    @Value("${course.message}")
    private String message;

    public String getMessage() {
        return message;
    }
}
