package com.baggio.customer.configuration

import com.baggio.clients.fraud.FraudService
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class CustomerConfiguration {

    @Bean
    @LoadBalanced
    fun webClient(): WebClient.Builder {
        return WebClient.builder()
    }

    @Bean
    fun fraudService(webClient: WebClient.Builder): FraudService {
        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(webClient
                .apply { it.baseUrl("http://FRAUD") }
                .build()))
            .build()
        return httpServiceProxyFactory.createClient(FraudService::class.java)
    }


}