package com.baggio.fraud.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "fraud_checks")
data class FraudCheckHistory(

    @Id
    @SequenceGenerator(
        name = "customer_id_sequence",
        sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_id_sequence"
    )
    val id: Long? = null,

    val customerId: Long,
    
    val isFraudster: Boolean,

    var createdAt: LocalDateTime

)