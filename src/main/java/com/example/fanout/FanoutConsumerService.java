package com.example.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.RabbitMQConst;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lanna
 * @Date 2022年7月9日
 */

@Service
@Slf4j
public class FanoutConsumerService {
    
    @RabbitListener(queues = { RabbitMQConst.FANOUT_QUEUE_A })
    public void consumerA(String msg) {
        log.info("Fanout queueA->consume: {}", msg);
    }
    
    @RabbitListener(queues = { RabbitMQConst.FANOUT_QUEUE_B })
    public void consumerB(String msg) {
        log.info("Fanout queueB->consume: {}", msg);
    }
}
