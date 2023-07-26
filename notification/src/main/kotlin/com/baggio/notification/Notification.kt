package com.baggio.notification

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "notifications")
data class Notification(

    @Id
    @SequenceGenerator(
        name = "notification_id_sequence",
        sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "notification_id_sequence"
    )
    val id: Long? = null,

    val customerId: Long,

    val customerEmail: String,

    val message: String,

    val sender: String,

    val sentAt: LocalDateTime
)
