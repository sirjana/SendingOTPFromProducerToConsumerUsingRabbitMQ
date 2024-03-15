package com.example.producer.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Component
public class RabbitMqProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "otp_exchange";
    private static final String ROUTING_KEY = "otp";
    private static final int OTP_LENGTH = 6;

    public void sendOTP(String otp) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, otp);
        System.out.println("OTP sent to consumer: " + otp);
    }

    public static String generateOtp() {
        String allowedChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder otp = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < OTP_LENGTH; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            otp.append(allowedChars.charAt(randomIndex));
        }

        return otp.toString();
    }

}

