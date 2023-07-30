package com.baggio.notification.rabbitmq

import com.baggio.clients.notification.NotificationRequest
import com.baggio.notification.NotificationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class NotificationConsumer(
    private val notificationService: NotificationService
) {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(NotificationConsumer::class.java)
    }

    @RabbitListener(queues = ["\${rabbitmq.queue.notification}"])
    fun consumeNotification(notificationRequest: NotificationRequest) {
        log.info("Message received from queue: $notificationRequest")
        notificationService.sendNotification(notificationRequest)
    }

}