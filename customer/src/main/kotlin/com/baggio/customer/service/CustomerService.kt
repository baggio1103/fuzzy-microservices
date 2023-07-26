package com.baggio.customer.service

import com.baggio.clients.fraud.FraudService
import com.baggio.customer.dto.CustomerRequest
import com.baggio.customer.model.CustomerEntity
import com.baggio.customer.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val fraudService: FraudService
) {

    fun registerCustomer(customerRequest: CustomerRequest) {
        val customer = customerRepository.saveAndFlush(
            CustomerEntity(
                firstName = customerRequest.firstName,
                lastName = customerRequest.lastName,
                email = customerRequest.email,
            )
        )
        val customerId = customer.id ?: throw IllegalArgumentException()
        val fraudCheckResponse = fraudService.isFraudulentCustomer(customerId) ?: throw IllegalArgumentException()
        println(fraudCheckResponse)
        // todo save into db

    }

}
