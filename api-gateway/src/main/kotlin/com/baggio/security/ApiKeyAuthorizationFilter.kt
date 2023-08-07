package com.baggio.security

import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.cloud.gateway.route.Route
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils
import org.springframework.core.Ordered
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class ApiKeyAuthorizationFilter(
    private val fakeApiKeyAuthorizationChecker: FakeApiKeyAuthorizationChecker
): GlobalFilter, Ordered {

    override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
        println("This is a apiKeyAuthorizationFilter checking key")
        val route = exchange.getAttribute<Route>(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR)
        val application = route?.id
        val apiKey = exchange.request.headers["ApiKey"]?.firstOrNull()
        if (application == null || apiKey == null ||
            !fakeApiKeyAuthorizationChecker.isAuthorized(apiKey, application)
        ) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "You are unauthorized")
        }
        println("Application Id: $application; ApiKey: $apiKey")
        return chain.filter(exchange)
    }

    override fun getOrder(): Int {
        return Ordered.LOWEST_PRECEDENCE
    }

}