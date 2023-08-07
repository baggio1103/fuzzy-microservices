package com.baggio

interface ApiKeyAuthorizationChecker {

    fun isAuthorized(apikey: String, application: String): Boolean

}