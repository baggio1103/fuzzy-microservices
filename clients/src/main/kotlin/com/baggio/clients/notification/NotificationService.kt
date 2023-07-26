package com.baggio.clients.notification

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange

@HttpExchange(url = "api/v1/notifications")
interface NotificationService {

    @PostExchange
    fun sendNotification(@RequestBody notificationRequest: NotificationRequest)

}