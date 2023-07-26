package com.baggio.fraud.service

import com.baggio.fraud.model.FraudCheckHistory
import com.baggio.fraud.model.repository.FraudCheckHistoryRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FraudCheckService(
    private val fraudCheckHistoryRepository: FraudCheckHistoryRepository
) {

    fun isFraudulentCustomer(customerId: Long): Boolean {
        fraudCheckHistoryRepository.save(
            FraudCheckHistory(
                customerId = customerId,
                isFraudster = false,
                createdAt = LocalDateTime.now()
            )
        )
        return false
    }

}