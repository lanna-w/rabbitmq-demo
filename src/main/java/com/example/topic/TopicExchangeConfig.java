package com.example.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.RabbitMQConst;

/**
 * @author Lanna
 * @Date 2022年7月9日
 */

@Configuration
public class TopicExchangeConfig {
    
    @Bean TopicExchange topicExchange() {
        return new TopicExchange(RabbitMQConst.TOPIC_EXCHANGE, true, false); 
    }
    
    @Bean Queue topicQueueA() {
        return new Queue(RabbitMQConst.TOPIC_QUEUE_A);
    }
    
    @Bean Queue topicQueueB() {
        return new Queue(RabbitMQConst.TOPIC_QUEUE_B);
    }
    
    @Bean Queue topicQueueC() {
        return new Queue(RabbitMQConst.TOPIC_QUEUE_C);
    }
    
    @Bean Binding bindTopicA() {
        return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with("a.*");
    }
    
    @Bean Binding bundTopicB() {
        return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with("b.*");
    }
    
    @Bean Binding bindTopicC() {
        return BindingBuilder.bind(topicQueueC()).to(topicExchange()).with("rabbit.#");
    }
}
