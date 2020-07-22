package com.m;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test001")
public class TestReceive {

    @RabbitHandler
    public void process(Object message){
        System.out.println(message);
    }
}
