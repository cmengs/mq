package com.m.test4;

import com.m.SpringbootRabbitReceiveApplication;
import com.m.test3.Test3Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 订阅模式
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SpringbootRabbitReceiveApplication.class)
public class Test4 {

    @Autowired
    private Test4Sender test4Sender;

    @Test
    public void test(){
        test4Sender.send();
    }
}
