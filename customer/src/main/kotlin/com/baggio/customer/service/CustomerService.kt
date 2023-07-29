package com.baggio.customer.service

import com.baggio.amqp.RabbitMQMessageProducer
import com.baggio.clients.fraud.FraudService
import com.baggio.clients.notification.NotificationRequest
import com.baggio.customer.dto.CustomerRequest
import com.baggio.customer.model.CustomerEntity
import com.baggio.customer.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val fraudService: FraudService,
    private val rabbitMQMessageProducer: RabbitMQMessageProducer,
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
        if (fraudCheckResponse.isFraudster) {
            throw IllegalStateException("Customer is fraudster")
        }
        rabbitMQMessageProducer.publish(
            NotificationRequest(
                customerId,
                customerRequest.email,
                "Welcome to Java Jedi"
            ),
            "internal.exchange",
            "internal.notification.routing-key"
        )
    }

}
