package com.baggio.amqp

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.stereotype.Component

@Component
class RabbitMQMessageProducer(
    private val ampqTemplate: AmqpTemplate
) {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(RabbitMQMessageProducer::class.java)
    }

    fun produce(payload: Any, exchange: String, routingKey: String) {
        log.info("Publishing to $exchange using routingKey: $routingKey. Payload: $payload")
        ampqTemplate.convertAndSend(exchange, routingKey, payload)
        log.info("Published to $exchange using routingKey: $routingKey. Payload: $payload")
    }

}