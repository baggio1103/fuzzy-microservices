package com.baggio.clients.fraud

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange

@HttpExchange(url = "/api/v1/fraud-check/")
interface FraudService {

    @GetExchange("/{customerId}")
    fun isFraudulentCustomer(@PathVariable("customerId") customerId: Long): FraudCheckResponse?

}