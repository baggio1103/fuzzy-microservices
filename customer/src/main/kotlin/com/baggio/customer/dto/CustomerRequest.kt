package com.baggio.customer.dto

import com.baggio.customer.model.CustomerEntity

data class CustomerRequest(
   val firstName: String,
   val lastName: String,
   val email: String
) {
    fun registerCustomer(customerRequest: CustomerRequest) {
        val id = 0L
        val customer = CustomerEntity(
            id,
            customerRequest.firstName,
            customerRequest.lastName,
            customerRequest.email,
        )
        // todo save into db
    }
}
