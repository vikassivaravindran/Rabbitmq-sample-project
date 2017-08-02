package com.vikas.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableRabbit
public class StudentConfig {

	@Value("${message.queue}")
	private String messageQueue;
	
	
	@Value("${exchange.name}")
	private String exchange;
	
	
	@Value("${message.key}")
	private String messageKey;
	
	@Bean
	public DirectExchange appexchange(){
	return new DirectExchange(exchange);
}
	
	@Bean
	public Queue MyQueue(){
		return new Queue(messageQueue);
	}
	
	@Bean
	public Binding MessageQueueBinding(){
		return BindingBuilder.bind(MyQueue()).to(appexchange()).with(messageKey);
	}
	
	
}
