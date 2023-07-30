package com.baggio.clients.notification

data class NotificationRequest(
    var customerId: Long,
    var customerEmail: String,
    var message: String
) {

    constructor(): this(0, "",  "")

}