package com.example.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.RabbitMQConst;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lanna
 * @Date 2022年7月9日
 */

@Component
@Slf4j
public class TopicConsumeService {
    
    @RabbitListener(queues = { RabbitMQConst.TOPIC_QUEUE_A })
    public void consumeA(String ms) {
        log.info("Topic queueA->consume: {}", ms);
    }
    
    @RabbitListener(queues = { RabbitMQConst.TOPIC_QUEUE_B })
    public void consumeB(String ms) {
        log.info("Topic queueB->consume: {}", ms);
    }
    
    @RabbitListener(queues = { RabbitMQConst.TOPIC_QUEUE_C })
    public void consumeC(String ms) {
        log.info("Topic queueC->consume: {}", ms);
    }
}
