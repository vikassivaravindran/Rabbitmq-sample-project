package com.vikas.config;

import org.springframework.amqp.core.Queue;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vikas.receiver.StudentReceiver;


@Configuration
@EnableRabbit
public class StudentConfig {
	

	@Value("${message.queue}")
	private String messageQueue;
	
	
	@Bean
	public Queue MyQueue(){
		return new Queue(messageQueue);
	}
	
	
	@Bean
	MessageListenerAdapter listenerAdapter(StudentReceiver receiver){
		return new MessageListenerAdapter(receiver,"receiveMessage");
		
	}
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory factory,MessageListenerAdapter listenerAdapter){
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(factory);
		simpleMessageListenerContainer.setQueueNames(messageQueue);
		simpleMessageListenerContainer.setMessageConverter(producerJackson2MessageConverter());
		simpleMessageListenerContainer.setMessageListener(listenerAdapter);
		simpleMessageListenerContainer.setPrefetchCount(1);
		return simpleMessageListenerContainer;	
	}
	

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter(){
		return new Jackson2JsonMessageConverter();
	}

}
