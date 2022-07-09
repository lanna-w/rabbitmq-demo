package com.example.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.RabbitMQConst;

/**
 * @author Lanna
 * @Date 2022年7月9日
 */

@Configuration
public class FanoutExchangeConfig {
    
    @Bean Queue fanoutQueueA() {
        return new Queue(RabbitMQConst.FANOUT_QUEUE_A);
    }
    
    @Bean Queue fanoutQueueB() {
        return new Queue(RabbitMQConst.FANOUT_QUEUE_B);
    }
    
    @Bean FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMQConst.FANOUT_EXCHANGE, true, false);
    }
    
    @Bean Binding bindFanoutA() {
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }
    
    @Bean Binding bindFanoutB() {
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }
}
