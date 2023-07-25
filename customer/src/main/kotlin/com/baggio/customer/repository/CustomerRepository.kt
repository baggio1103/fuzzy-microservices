package com.baggio.customer.repository

import com.baggio.customer.model.CustomerEntity
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<CustomerEntity, Long> {
}