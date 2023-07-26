package com.baggio.fraud.controller

import com.baggio.fraud.dto.FraudCheckResponse
import com.baggio.fraud.service.FraudCheckService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/fraud-check")
class FraudController(
    private val fraudCheckService: FraudCheckService
) {

    @GetMapping("/{customerId}")
    fun isFraudster(@PathVariable("customerId") customerId: Long): FraudCheckResponse {
        val isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId)
        return FraudCheckResponse(isFraudulentCustomer)
    }

}