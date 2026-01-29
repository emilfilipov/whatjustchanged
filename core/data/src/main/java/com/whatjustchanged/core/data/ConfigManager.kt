package com.whatjustchanged.core.data

import javax.inject.Inject
import javax.inject.Singleton

interface ConfigManager {
    fun getApiUrl(): String
    fun getApiKey(): String
    fun getPort(): Int
}

@Singleton
class DefaultConfigManager @Inject constructor() : ConfigManager {
    // In a real app, these would come from BuildConfig or a remote config service
    // For now, we will return default values or placeholder values
    
    override fun getApiUrl(): String {
        return "https://api.example.com"
    }

    override fun getApiKey(): String {
        return "placeholder_api_key"
    }

    override fun getPort(): Int {
        return 8080
    }
}
