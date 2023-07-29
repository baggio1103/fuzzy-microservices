package com.baggio.customer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(
    scanBasePackages = [
        "com.baggio.amqp",
        "com.baggio.customer",
    ]
)
class CustomerApplication

fun main() {
    SpringApplication.run(CustomerApplication::class.java)
}
