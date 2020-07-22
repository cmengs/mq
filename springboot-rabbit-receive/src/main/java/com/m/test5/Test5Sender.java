package com.m.test5;

import com.m.config.Config;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Test5Sender {

    @Autowired
    private RabbitTemplate template;

    public void send(){
        template.convertAndSend(Config.FanoutDirect_01,Config.Exchange_Direct_Routing_Key_A,"消息");
    }
}
