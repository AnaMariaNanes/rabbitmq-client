package com.example.rabbitmq.rabbitmq.client;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMQClientApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void run( String... strings ) {

		SimpleMessage simpleMessage = new SimpleMessage( "ClientMessage", "simpleDescription" );
		rabbitTemplate.convertAndSend( "MyTopicExchange", "topic", simpleMessage );

	}

	public static void main( String[] args ) {
		SpringApplication.run( RabbitMQClientApplication.class, args );
	}
}
