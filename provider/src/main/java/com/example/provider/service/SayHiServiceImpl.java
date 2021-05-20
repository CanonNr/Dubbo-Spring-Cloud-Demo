package com.example.provider.service;

import org.apache.dubbo.config.annotation.Service;
import service.SayHiService;

@Service
public class SayHiServiceImpl implements SayHiService {
    public String say(String message) {
        return "Hi "+message;
    }
}
