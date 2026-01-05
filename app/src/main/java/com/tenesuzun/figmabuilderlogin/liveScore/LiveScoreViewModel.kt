package com.tenesuzun.figmabuilderlogin.liveScore

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class LiveScoreUiState(
    val selectedTab: Int = 1, // 0: Standings, 1: Fixtures
    val selectedLeague: String = "Spor Toto Süper Lig",
    val selectedWeek: String = "3. Hafta",
    val matches: List<Match> = MockData.sampleMatches,
    val standings: List<Standing> = MockData.sampleStandings,
    val isLoading: Boolean = false,
    val error: String? = null
)

class LiveScoreViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LiveScoreUiState())
    val uiState: StateFlow<LiveScoreUiState> = _uiState.asStateFlow()
    
    fun selectTab(tabIndex: Int) {
        _uiState.value = _uiState.value.copy(selectedTab = tabIndex)
    }
    
    fun selectLeague(league: String) {
        _uiState.value = _uiState.value.copy(
            selectedLeague = league,
            isLoading = true
        )
        // Simulate loading data
        // In real app, fetch data from repository
        _uiState.value = _uiState.value.copy(isLoading = false)
    }
    
    fun selectWeek(week: String) {
        _uiState.value = _uiState.value.copy(
            selectedWeek = week,
            isLoading = true
        )
        // Simulate loading data
        _uiState.value = _uiState.value.copy(isLoading = false)
    }
    
    fun refreshData() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        // Simulate data refresh
        _uiState.value = _uiState.value.copy(
            matches = MockData.sampleMatches,
            standings = MockData.sampleStandings,
            isLoading = false
        )
    }
}
