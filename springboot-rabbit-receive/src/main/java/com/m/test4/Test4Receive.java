package com.m.test4;

import com.m.config.Config;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Test4Receive {

    @RabbitListener(queues = Config.QueueName_Exchang_FanoutA)
    public void processA(String string){
        System.out.println("processA:"+string);
    }

    @RabbitListener(queues = Config.QueueName_Exchang_FanoutB)
    public void processB(String string){
        System.out.println("processB:"+string);
    }

    @RabbitListener(queues = Config.QueueName_Exchang_FanoutC)
    public void processC(String string){
        System.out.println("processC:"+string);
    }
}
