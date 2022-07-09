package com.example.direct;

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
public class DirectConsumerService {

    @RabbitListener(queues = RabbitMQConst.DIRECT_QUEUE)
    public void consume(String msg) {
        log.info("Direct queue->consume: {}", msg);
    }
}
