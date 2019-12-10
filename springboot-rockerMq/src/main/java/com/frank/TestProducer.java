package com.frank;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:32 2019-12-10
 * @ Description：测试消息发送者
 * @ Modified By：
 */
@Service
public class TestProducer {
    @Autowired private RocketMQTemplate rocketMQTemplate;
    public void sendMsg(String topic,String msg){
        this.rocketMQTemplate.convertAndSend(topic,msg);
        System.out.println("发送消息成功msg:"+msg+" topic:"+topic);
    }
}
