package com.baggio.fraud.model.repository

import com.baggio.fraud.model.FraudCheckHistory
import org.springframework.data.jpa.repository.JpaRepository

interface FraudCheckHistoryRepository: JpaRepository<FraudCheckHistory, Long> {
}