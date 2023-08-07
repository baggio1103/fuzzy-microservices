package com.baggio.customer.configuration

import com.baggio.clients.fraud.FraudService
import com.baggio.clients.notification.NotificationService
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClient.Builder
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class CustomerClientConfiguration {

    @Bean
    @LoadBalanced
    fun webClient(): Builder {
        return WebClient.builder()
    }

    @Bean
    fun fraudService(
        webClient: Builder,
        @Value("\${service.fraud.url}") fraudServiceUrl: String
    ): FraudService {
        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(webClient
                .apply { it.baseUrl(fraudServiceUrl) }
                .build()))
            .build()
        return httpServiceProxyFactory.createClient(FraudService::class.java)
    }

    @Bean
    fun notificationService(
        webClient: Builder,
        @Value("\${service.notification.url}") notificationUrl: String
    ): NotificationService {
        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(webClient
                .apply { it.baseUrl(notificationUrl) }
                .build()))
            .build()
        return httpServiceProxyFactory.createClient(NotificationService::class.java)
    }

}