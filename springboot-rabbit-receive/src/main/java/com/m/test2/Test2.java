package com.m.test2;

import com.m.SpringbootRabbitReceiveApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= SpringbootRabbitReceiveApplication.class)
public class Test2 {

    @Autowired
    private Test2Sender send;

    @Test
    public void test(){
        send.send();
    }
}
