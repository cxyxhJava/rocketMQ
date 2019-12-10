package com.frank;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:43 2019-12-10
 * @ Description：测试消费者
 * @ Modified By：
 */
@Component
@RocketMQMessageListener(
        topic = "springboot-rockermq-topic",
        consumerGroup = "springboot-rockermq-consumer",
        selectorExpression = "*"
)
public class TestConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String msg) {
        System.out.println("接收到消息 -> " + msg);
    }
}
