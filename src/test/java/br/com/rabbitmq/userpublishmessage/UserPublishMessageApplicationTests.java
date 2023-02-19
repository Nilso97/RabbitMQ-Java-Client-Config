package br.com.rabbitmq.userpublishmessage;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rabbitmq.userpublishmessage.config.UserMessageConfig;
import br.com.rabbitmq.userpublishmessage.publisher.model.User;

@SpringBootTest
class UserPublishMessageApplicationTests {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Test
	public void must_send_a_message_to_the_consumer() {
		var user = new User(
			"John Doe", 
			"john.doe@gmail.com", 
			"Tarefas do dia 19/02/2023", 
			"RabbitMQ com Spring Boot"
		);
		rabbitTemplate.convertAndSend(UserMessageConfig.EXCHANGE_NAME, UserMessageConfig.ROUTING_KEY, user);
	}

}
