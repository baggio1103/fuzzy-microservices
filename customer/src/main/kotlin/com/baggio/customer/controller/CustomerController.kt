package com.baggio.customer.controller

import com.baggio.customer.dto.CustomerRequest
import com.baggio.customer.service.CustomerService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customer")
class CustomerController(
    private val customerService: CustomerService
) {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(CustomerController::class.java)
    }

    @PostMapping
    fun registerCustomer(customerRequest: CustomerRequest) {
        log.info("Customer registration request {}", customerRequest)
        customerService.registerCustomer(customerRequest)
    }

}