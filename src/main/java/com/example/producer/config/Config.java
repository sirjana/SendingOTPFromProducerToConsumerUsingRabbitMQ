package com.example.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    public static final String EXCHANGE_NAME = "otp_exchange";
    public static final String QUEUE_NAME = "otp_queue";
    public static final String ROUTING_KEY = "otp";

    @Bean
    public Queue otpQueue() {
        return new Queue(QUEUE_NAME);
    }
    @Bean
    public DirectExchange otpExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }
    @Bean
    public Binding binding(Queue otpQueue, DirectExchange otpExchange) {
        return BindingBuilder.bind(otpQueue).to(otpExchange).with(ROUTING_KEY);
    }
}
