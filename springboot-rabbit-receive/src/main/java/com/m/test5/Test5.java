package com.m.test5;

import com.m.SpringbootRabbitReceiveApplication;
import com.m.test4.Test4Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 路由模式
 * 与广播模式区别所在：
 *
 * 广播模式：队列与交换机绑定以后，只需要将消息发送至该交换机，那么所有监听该交换机队列的接收端，都能收到消息
 * 路由模式：队列与交换机绑定时 添加队列路由名称，那么在发送信息的时候，只需要传路由器名称和该队列路由名称即可实现只向指定的某一个队列发送消息
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SpringbootRabbitReceiveApplication.class)
public class Test5 {

    @Autowired
    private Test5Sender test5Sender;

    @Test
    public void test(){
        test5Sender.send();
    }
}
