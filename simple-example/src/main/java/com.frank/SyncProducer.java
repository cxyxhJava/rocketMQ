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



//        //Instantiate with a producer group name.
//        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
//        // Specify name server addresses.
//        producer.setNamesrvAddr("http://dev-oa-rocketmq-console.geelytech.com/:9876");
//        //Launch the instance.
//        producer.createTopic("testKey","testTopic",1024);
//        producer.start();
//        for (int i = 0; i < 100; i++) {
//            //Create a message instance, specifying topic, tag and message body.
//            Message msg = new Message("TopicTest" /* Topic */,
//                    "TagA" /* Tag */,
//                    ("Hello RocketMQ " +
//                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
//            );
//            //Call send message to deliver message to one of brokers.
//            SendResult sendResult = producer.send(msg);
//            System.out.printf("%s%n", sendResult);
//        }
//        //Shut down once the producer instance is not longer in use.
//        producer.shutdown();
    }

}
