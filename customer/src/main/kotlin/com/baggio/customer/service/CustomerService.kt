package com.baggio.customer.service

import com.baggio.customer.dto.CustomerRequest
import com.baggio.customer.dto.FraudCheckResponse
import com.baggio.customer.model.CustomerEntity
import com.baggio.customer.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.lang.IllegalArgumentException

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val restTemplate: RestTemplate
) {

    fun registerCustomer(customerRequest: CustomerRequest) {
        val customer = customerRepository.saveAndFlush(
            CustomerEntity(
                firstName = customerRequest.firstName,
                lastName = customerRequest.lastName,
                email = customerRequest.email,
            )
        )
        val fraudCheckResponse = restTemplate.getForObject(
            "http://localhost:8081/api/v1/fraud-check/{customerId}",
            FraudCheckResponse::class.java,
            customer.id
            ) ?: throw IllegalStateException("")
        if (fraudCheckResponse.isFraudster) {
            throw IllegalArgumentException("Customer with id: ${customer.id} is fraudster")
        }
        // todo save into db

    }

}
