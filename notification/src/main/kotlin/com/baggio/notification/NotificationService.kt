package com.baggio.notification

import com.baggio.clients.notification.NotificationRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NotificationService(
    private val notificationRepository: NotificationRepository
) {

    fun sendNotification(notificationRequest: NotificationRequest) {
        notificationRepository.save(
            Notification(
                customerId = notificationRequest.customerId,
                customerEmail = notificationRequest.customerEmail,
                message = notificationRequest.message,
                sender = "Java Jedi",
                sentAt = LocalDateTime.now()
            )
        )
    }

}