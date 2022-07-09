package com.example.header;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
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
public class HeaderConsumerService {
    
    @RabbitListener(queues = { RabbitMQConst.HEADER_QUEUE_A })
    public void consumeA(Message message) throws UnsupportedEncodingException {
        MessageProperties messageProperties = message.getMessageProperties();
        String contentType = messageProperties.getContentType();
        log.info("Header queueA->consume: {}", new String(message.getBody(), contentType));
    }
    
    @RabbitListener(queues = { RabbitMQConst.HEADER_QUEUE_B })
    public void consumeB(Message message) throws UnsupportedEncodingException {
        MessageProperties messageProperties = message.getMessageProperties();
        String contentType = messageProperties.getContentType();
        log.info("Header queueB->consume: {}", new String(message.getBody(), contentType));
    }
}
