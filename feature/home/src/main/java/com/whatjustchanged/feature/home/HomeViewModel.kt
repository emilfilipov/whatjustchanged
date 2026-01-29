package com.whatjustchanged.feature.home

import androidx.lifecycle.ViewModel
import com.whatjustchanged.core.data.ConfigManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val configManager: ConfigManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadConfig()
    }

    private fun loadConfig() {
        _uiState.value = HomeUiState(
            apiUrl = configManager.getApiUrl(),
            apiKey = configManager.getApiKey(),
            port = configManager.getPort()
        )
    }
}

data class HomeUiState(
    val apiUrl: String = "",
    val apiKey: String = "",
    val port: Int = 0
)
