package com.example.direct;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.RabbitMQConst;

/**
 * @author Lanna
 * @Date 2022年7月9日
 */

@RestController
public class DirectProduceController {
    
    @Resource
    private RabbitTemplate rabbitTemplate;
    
    @GetMapping("/direct/{msg}")
    public void produce(@PathVariable String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConst.DIRECT_EXCHANGE, RabbitMQConst.DIRECT_ROUTING_KEY, msg);
    }
}
