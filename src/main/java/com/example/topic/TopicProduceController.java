package com.example.topic;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RabbitMQConst;

/**
 * @author Lanna
 * @Date 2022年7月9日
 */

@RestController
public class TopicProduceController {
    @Resource
    RabbitTemplate rabbitTemplate;
    
    @GetMapping("/topic")
    public void produce(@RequestParam(name = "msg")String msg, @RequestParam(name = "routingKey") String routingKey) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("routingKey", routingKey);
        rabbitTemplate.convertAndSend(RabbitMQConst.TOPIC_EXCHANGE, routingKey, map.toString());
    }
}
