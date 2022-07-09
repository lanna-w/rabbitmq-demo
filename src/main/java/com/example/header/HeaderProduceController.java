package com.example.header;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
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
public class HeaderProduceController {
    @Resource
    private RabbitTemplate rabbitTemplate;
    
    @GetMapping("/header")
    public void produce(@RequestParam(name = "key") String key, @RequestParam(name = "value") String value, 
            @RequestParam(name = "msg") String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        messageProperties.setContentType("UTF-8");
        messageProperties.getHeaders().putAll(map);
        Message message = new Message(msg.getBytes(), messageProperties);
        rabbitTemplate.convertAndSend(RabbitMQConst.HEADER_EXCHANGE, "", message);
    }
}
