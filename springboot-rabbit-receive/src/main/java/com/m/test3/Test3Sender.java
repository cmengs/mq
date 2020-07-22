package com.m.test3;

import com.m.config.Config;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Test3Sender {

    @Autowired
    private RabbitTemplate template;

    public void send(){
        int count = 1000;
        for (int i = 0; i < count; i++) {
            template.convertAndSend(Config.QueueName_Test003,"第"+i + "次请求-----");
        }
    }

}
