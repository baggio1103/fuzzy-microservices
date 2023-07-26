package com.baggio.notification

import com.baggio.clients.notification.NotificationRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/notifications")
class NotificationController(
    private val notificationService: NotificationService
) {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(NotificationController::class.java)
    }

    @PostMapping
    fun sendNotification(@RequestBody notificationRequest: NotificationRequest) {
        log.info("New notification: $notificationRequest")
        notificationService.sendNotification(notificationRequest)
    }

}