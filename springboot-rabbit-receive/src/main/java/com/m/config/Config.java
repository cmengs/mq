package com.m.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Config {

    public static final String QueueName_Hello = "hello";
    public static final String QueueName_Q_Test = "q_test";
    public static final String QueueName_Q_Test_01 = "q_test_01";
    public static final String QueueName_Q_Test_02 = "q_test_02";
    public static final String QueueName_Q_Test_03 = "q_test_03";
    public static final String QueueName_Q_Test_03_1 = "q_test_03_1";
    public static final String QueueName_Test = "test";
    public static final String QueueName_Test001 = "test001";
    public static final String QueueName_Test002 = "test002";
    public static final String QueueName_Test003 = "test003";

    @Bean(name = QueueName_Hello)
    public Queue Queue(){
        return new Queue(QueueName_Hello);
    }

    @Bean(name = QueueName_Q_Test)
    public Queue Queue1(){
        return new Queue(QueueName_Q_Test);
    }

    @Bean(name = QueueName_Q_Test_01)
    public Queue Queue2(){
        return new Queue(QueueName_Q_Test_01);
    }

    @Bean(name = QueueName_Q_Test_02)
    public Queue Queue3(){
        return new Queue(QueueName_Q_Test_02);
    }

    @Bean(name = QueueName_Q_Test_03)
    public Queue Queue4(){
        return new Queue(QueueName_Q_Test_03);
    }

    @Bean(name = QueueName_Q_Test_03_1)
    public Queue Queue5(){
        return new Queue(QueueName_Q_Test_03_1);
    }

    @Bean(name = QueueName_Test)
    public Queue Queue6(){
        return new Queue(QueueName_Test);
    }

    @Bean(name = QueueName_Test001)
    public Queue Queue7(){
        return new Queue(QueueName_Test001);
    }

    @Bean(name = QueueName_Test002)
    public Queue Queue8(){
        return new Queue(QueueName_Test002);
    }

    @Bean(name = QueueName_Test003)
    public Queue Queue9(){
        return new Queue(QueueName_Test003);
    }


    /////////////////////////////////订阅模式（发布模式，广播）//////////////////////////////////////////
    public static final String FanoutExchange_01 = "fanoutExchange_01"; //广播交换机
    //创建三个广播队列
    public static final String QueueName_Exchang_FanoutA = "fanout.A";
    public static final String QueueName_Exchang_FanoutB = "fanout.B";
    public static final String QueueName_Exchang_FanoutC = "fanout.C";

    @Bean(name=QueueName_Exchang_FanoutA)
    public Queue AMessage() {
        return new Queue(QueueName_Exchang_FanoutA);
    }

    @Bean(name=QueueName_Exchang_FanoutB)
    public Queue BMessage() {
        return new Queue(QueueName_Exchang_FanoutB);
    }

    @Bean(name=QueueName_Exchang_FanoutC)
    public Queue CMessage() {
        return new Queue(QueueName_Exchang_FanoutC);
    }

    @Bean(name=FanoutExchange_01)
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FanoutExchange_01);//配置广播交换机
    }

    //广播交换机与队列绑定
    @Bean
    Binding bindingA(@Qualifier(QueueName_Exchang_FanoutA) Queue queue, FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    Binding bindingB(@Qualifier(QueueName_Exchang_FanoutB) Queue queue, FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    Binding bindingC(@Qualifier(QueueName_Exchang_FanoutC) Queue queue, FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    ////////////////////////////////////////订阅模式（发布模式，广播） 结束//////////////////////////////////////////////////////////

    ////////////////////////////////////////////路由模式///////////////////////////////////////////////////////////////////////////
    public static final String FanoutDirect_01 = "fanoutDirect_01"; //路由器名称
    //创建两个队列
    public static final String QueueName_Exchang_DirectA = "felix-queue-A";
    public static final String QueueName_Exchang_DirectB = "felix-queue-B";

    @Bean(name=QueueName_Exchang_DirectA)
    public Queue directA(){
        return new Queue(QueueName_Exchang_DirectA);
    }
    @Bean(name=QueueName_Exchang_DirectB)
    public Queue directB(){
        return new Queue(QueueName_Exchang_DirectB);
    }

    @Bean(name = FanoutDirect_01)
    DirectExchange directExchange(){
        return new DirectExchange(FanoutDirect_01); //配置路由器
    }

    public static final String Exchange_Direct_Routing_Key_A = "AAA";
    public static final String Exchange_Direct_Routing_Key_B = "BBB";

    //路由器与队列绑定
    @Bean
    Binding bindDirectA(@Qualifier(QueueName_Exchang_DirectA) Queue queue,DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(Exchange_Direct_Routing_Key_A);
    }

    @Bean
    Binding bindDirectB(@Qualifier(QueueName_Exchang_DirectB) Queue queue,DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(Exchange_Direct_Routing_Key_B);
    }
}
