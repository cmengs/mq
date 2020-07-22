package com.m.test4;

import com.m.config.Config;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Test4Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(){
        rabbitTemplate.convertAndSend(Config.FanoutExchange_01,"","向交换机发送信息");
    }
}
