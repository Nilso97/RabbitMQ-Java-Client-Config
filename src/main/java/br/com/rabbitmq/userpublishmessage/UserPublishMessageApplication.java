package br.com.rabbitmq.userpublishmessage;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
public class UserPublishMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserPublishMessageApplication.class, args);
	}

	@Bean
	public org.springframework.amqp.support.converter.MessageConverter jsonMessageConverter() {
		final ObjectMapper om = new ObjectMapper();
		om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.registerModule(new JavaTimeModule());
		return new Jackson2JsonMessageConverter(om);
	}

}
