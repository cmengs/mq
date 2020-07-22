package com.m.test2;

import com.m.SpringbootRabbitReceiveApplication;
import com.m.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;


@Controller
public class Test2Sender {

    @Autowired
    private RabbitTemplate template;

    public void send(){
        int count = 999999;
        for (int i = 0; i < count; i++) {
            String context = "hello,my code";
            System.out.println(context);
            template.convertAndSend(Config.QueueName_Test002,context);
        }
    }
}
