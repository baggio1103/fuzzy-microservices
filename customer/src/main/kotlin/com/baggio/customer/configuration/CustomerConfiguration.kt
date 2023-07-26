package com.baggio.customer.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class CustomerConfiguration {

    @Bean
    fun restTemplate(): RestTemplate = RestTemplate()


}