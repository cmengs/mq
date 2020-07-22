package com.m.test3;

import com.m.SpringbootRabbitReceiveApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * work 模式，资源抢占类似负载均衡
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitReceiveApplication.class)
public class Tes3 {

    @Autowired
    private Test3Sender test3Sender;

    @Test
    public void test(){
        test3Sender.send();
    }
}
