package com.baggio.fraud.controller

import com.baggio.fraud.dto.FraudCheckResponse
import com.baggio.fraud.service.FraudCheckService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/fraud-check")
class FraudController(
    private val fraudCheckService: FraudCheckService
) {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(FraudController::class.java)
    }

    @GetMapping("/{customerId}")
    fun isFraudster(@PathVariable("customerId") customerId: Long): FraudCheckResponse {
        log.info("Fraud check request for customer with id: {}", customerId)
        val isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId)
        return FraudCheckResponse(isFraudulentCustomer)
    }

}