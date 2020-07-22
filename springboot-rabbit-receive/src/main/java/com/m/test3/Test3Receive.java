package com.m.test3;

import com.m.config.Config;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Test3Receive {

    @RabbitHandler
    @RabbitListener(queues = Config.QueueName_Test003)
    public void process1(String string){
        System.err.println("Test3Receive1:"+string);
    }

    @RabbitHandler
    @RabbitListener(queues = Config.QueueName_Test003)
    public void process2(String string){
        System.err.println("Test3Receive2:"+string);
    }

    @RabbitHandler
    @RabbitListener(queues = Config.QueueName_Test003)
    public void process3(String string){
        System.err.println("Test3Receive3:"+string);
    }
}
