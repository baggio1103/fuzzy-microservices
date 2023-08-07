package com.baggio.security

import com.baggio.ApiKeyAuthorizationChecker
import org.springframework.stereotype.Service

@Service("fake")
class FakeApiKeyAuthorizationChecker: ApiKeyAuthorizationChecker {

    companion object {
        private val keys = mapOf(
            "secure-key" to listOf("customer")
        )
    }

    override fun isAuthorized(apikey: String, application: String): Boolean {
        return keys[apikey]?.contains(application) ?: false
    }

}