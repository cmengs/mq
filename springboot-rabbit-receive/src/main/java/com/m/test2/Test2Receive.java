package com.m.test2;

import com.m.config.Config;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Config.QueueName_Test002)
public class Test2Receive {

    @RabbitHandler
    public void process(Object value){
        System.err.println(value);
    }
}
