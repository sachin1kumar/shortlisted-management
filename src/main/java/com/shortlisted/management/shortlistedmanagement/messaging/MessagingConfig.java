package com.shortlisted.management.shortlistedmanagement.messaging;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    @Value("${spring.rabbitmq.addShortListedQueue}")
    private String addShortlistedQueue;

    @Value("${spring.rabbitmq.removeShortListedQueue}")
    private String removeShortListedQueue;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.addShortListedRoutingKey}")
    private String addShortListedRoutingKey;

    @Value("${spring.rabbitmq.removeShortListedRoutingKey}")
    private String removeShortListedRoutingKey;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Bean
    public Queue addQueue() {
        return new Queue(addShortlistedQueue, true);
    }

    @Bean
    public Queue removeQueue() {
        return new Queue(removeShortListedQueue, true);
    }

    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.topicExchange(exchange).durable(true).build();
    }

    @Bean
    Binding addShortlistedBinding() {
        return BindingBuilder
                .bind(addQueue())
                .to(myExchange())
                .with(addShortListedRoutingKey)
                .noargs();
    }

    @Bean
    Binding removeShortlistedBinding() {
        return BindingBuilder
                .bind(removeQueue())
                .to(myExchange())
                .with(removeShortListedRoutingKey)
                .noargs();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}