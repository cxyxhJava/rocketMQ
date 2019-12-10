package com.frank;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:22 2019-12-03
 * @ Description：同步消息提供者
 * @ Modified By：
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {


        DefaultMQProducer producer = new DefaultMQProducer("simpleExampleProducerGroup");
        producer.setNamesrvAddr("localhost:9876");
        System.out.println(producer.getCreateTopicKey());
        producer.start();
        System.out.println(producer.getCreateTopicKey());

        for (int i = 0; i < 10; i++) {
            byte[] message = ("hello RocketMQ" + i).getBytes();
            Message msg = new Message("simpleExample",message);
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n",sendResult);
        }
    }

}
