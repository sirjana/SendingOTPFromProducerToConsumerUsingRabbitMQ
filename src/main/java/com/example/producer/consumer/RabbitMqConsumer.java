package com.example.producer.consumer;
import com.example.producer.Data.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {

    @RabbitListener(queues = "otp_queue")
    public void consumeFirstQueueMessage(String otp){
        System.out.println("Received OTP" + otp);
    }
}
