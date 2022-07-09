package com.example.header;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.RabbitMQConst;

/**
 * @author Lanna
 * @Date 2022年7月9日
 */

@Configuration
public class HeaderExchangeConfig {
    @Bean HeadersExchange headersExchange() {
        return new HeadersExchange(RabbitMQConst.HEADER_EXCHANGE);
    }
    
    @Bean Queue headersQueueA() {
        return new Queue(RabbitMQConst.HEADER_QUEUE_A);
    }
    
    @Bean Queue headersQueueB() {
        return new Queue(RabbitMQConst.HEADER_QUEUE_B);
    }
    
    @Bean Binding bindHeadersA() {
        Map<String, Object> map = new HashMap<>();
        map.put("A_one", "one");
        map.put("A_two", "two");
        return BindingBuilder.bind(headersQueueA()).to(headersExchange())
                .whereAny(map).match();
    }
    
    @Bean Binding bindHeadersB() {
        Map<String, Object> map = new HashMap<>();
        map.put("B_one", "one");
        map.put("B_two", "two");
        return BindingBuilder.bind(headersQueueB()).to(headersExchange())
                .whereAny(map).match();
    }
}
