package com.frank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:01 2019-12-10
 * @ Description：
 * @ Modified By：
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired private TestProducer testProducer;

    @GetMapping("/mq/{msg}")
    public void sendMessage(@PathVariable("msg")String msg){
        testProducer.sendMsg("springboot-rockermq-topic",msg);
    }
}
