package com.baggio.customer.service

import com.baggio.customer.dto.CustomerRequest
import com.baggio.customer.model.CustomerEntity
import com.baggio.customer.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {

    fun registerCustomer(customerRequest: CustomerRequest) {
        val customer = CustomerEntity(
            firstName = customerRequest.firstName,
            lastName = customerRequest.lastName,
            email = customerRequest.email,
        )
        // todo save into db
        customerRepository.save(customer)
    }

}
