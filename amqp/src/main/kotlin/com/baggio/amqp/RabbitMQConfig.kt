package com.baggio.amqp

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Bean
    fun connectionFactory(): ConnectionFactory {
        return CachingConnectionFactory()
    }

    @Bean
    fun messageConverter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun simpleRabbitListenerContainerFactory(
        connectionFactory: ConnectionFactory,
        messageConverter: MessageConverter
    ): SimpleRabbitListenerContainerFactory {
        return SimpleRabbitListenerContainerFactory().also {
            it.setConnectionFactory(connectionFactory)
            it.setMessageConverter(messageConverter)
        }
    }

    @Bean
    fun amqp(
        connectionFactory: ConnectionFactory,
        messageConverter: MessageConverter
    ): AmqpTemplate {
        return RabbitTemplate(connectionFactory).also {
            it.messageConverter = messageConverter
        }
    }

}