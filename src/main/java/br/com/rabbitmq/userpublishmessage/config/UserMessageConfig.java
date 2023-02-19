package br.com.rabbitmq.userpublishmessage.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMessageConfig {

    public static final String QUEUE_NAME = "user_queue";
    public static final String EXCHANGE_NAME = "user_exchange";
    public static final String ROUTING_KEY = "publish_message";

    @Bean
    public DirectExchange userMessageExchangeConfiguration() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public org.springframework.amqp.core.Queue userMessageQueueConfiguration() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    public Binding userMessageBinding() {
        return BindingBuilder
                .bind(userMessageQueueConfiguration())
                .to(userMessageExchangeConfiguration())
                .with(ROUTING_KEY);
    }
}
