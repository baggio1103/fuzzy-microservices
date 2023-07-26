package com.baggio.customer.repository

import com.baggio.customer.model.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<CustomerEntity, Long> {
}