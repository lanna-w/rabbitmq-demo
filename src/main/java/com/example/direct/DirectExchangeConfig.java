package com.example.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.RabbitMQConst;

/**
 * @author Lanna
 * @Date 2022年7月9日
 */

@Configuration
public class DirectExchangeConfig {
    
    @Bean
    public Queue directQueue() {
        return new Queue(RabbitMQConst.DIRECT_QUEUE, true, false, false);
    }
    
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMQConst.DIRECT_EXCHANGE, true, false);
    }
    
    @Bean
    public Binding bindDirect() {
        return BindingBuilder.bind(directQueue())
                .to(directExchange())
                .with(RabbitMQConst.DIRECT_ROUTING_KEY);
    }
}
