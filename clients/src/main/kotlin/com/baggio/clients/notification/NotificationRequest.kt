package com.baggio.clients.notification

data class NotificationRequest(
    val customerId: Long,
    val customerEmail: String,
    val message: String
)