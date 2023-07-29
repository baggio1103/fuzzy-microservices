package com.baggio.notification

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class NotificationConfig(
    @Value("\${rabbitmq.exchanges.internal}")
    val internalExchange: String,
    @Value("\${rabbitmq.queue.notification}")
    val notificationQueue: String,
    @Value("\${rabbitmq.routing-keys.internal-communication}")
    val internalCommunicationRoutingKey: String,
) {

    @Bean
    fun topicExchange(): TopicExchange {
        return TopicExchange(internalExchange)
    }

    @Bean
    fun notificationQueue(): Queue {
        return Queue(notificationQueue)
    }

    @Bean
    fun binding(
        queue: Queue,
        topicExchange: TopicExchange
    ): Binding {
        return BindingBuilder
            .bind(queue)
            .to(topicExchange)
            .with(internalCommunicationRoutingKey)
    }

}