package com.example.producer.controller;

import com.example.producer.publisher.RabbitMqProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    private final RabbitMqProducer messageProducer;

    public BaseController(RabbitMqProducer messageProducer){
        this.messageProducer = messageProducer;
    }

    @GetMapping("/send-otp")
    public String sendOTP() {
        String otp = RabbitMqProducer.generateOtp();
        messageProducer.sendOTP(otp);
        return "OTP sent: " + otp;
    }
}
