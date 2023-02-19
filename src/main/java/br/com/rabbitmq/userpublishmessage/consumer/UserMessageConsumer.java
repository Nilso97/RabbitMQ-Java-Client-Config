package br.com.rabbitmq.userpublishmessage.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.rabbitmq.userpublishmessage.config.UserMessageConfig;
import br.com.rabbitmq.userpublishmessage.publisher.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserMessageConsumer {

    @RabbitListener(
        bindings = @QueueBinding(value = @Queue(UserMessageConfig.QUEUE_NAME), 
        exchange = @Exchange(name = UserMessageConfig.EXCHANGE_NAME), 
        key = UserMessageConfig.ROUTING_KEY)
    )
    public void sendMessageProcess(final Message message, final User user) {

        System.out.println("\n--- RabbitMQ Informations ---");
        log.info("Consumer Queue: " + message.getMessageProperties().getConsumerQueue());

        System.out.println("\n");
        log.info("Dados recebidos pelo consumidor: "
                + "{ name: " + user.getName()
                + ", email: " + user.getEmail()
                + ", subject: " + user.getSubject()
                + ", description: " + user.getDescription()
                + "}");
    }
}
