package com.m.test5;

import com.m.config.Config;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Test5Receive {

    @RabbitListener(queues = Config.QueueName_Exchang_DirectA)
    @RabbitHandler
    public void processA(String string){
        System.out.println("processA:"+string);
    }

    @RabbitListener(queues = Config.QueueName_Exchang_DirectB)
    @RabbitHandler
    public void processC(String string){
        System.out.println("processB:"+string);
    }
}
