package com.tenesuzun.figmabuilderlogin.liveScore

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LiveScoreViewModelTest {
    
    private lateinit var viewModel: LiveScoreViewModel
    
    @Before
    fun setup() {
        viewModel = LiveScoreViewModel()
    }
    
    @Test
    fun `initial state should have fixtures tab selected`() = runTest {
        val state = viewModel.uiState.value
        assertEquals(1, state.selectedTab)
    }
    
    @Test
    fun `selectTab should update selected tab`() = runTest {
        viewModel.selectTab(0)
        assertEquals(0, viewModel.uiState.value.selectedTab)
        
        viewModel.selectTab(1)
        assertEquals(1, viewModel.uiState.value.selectedTab)
    }
    
    @Test
    fun `selectLeague should update selected league`() = runTest {
        val newLeague = "1. Lig"
        viewModel.selectLeague(newLeague)
        assertEquals(newLeague, viewModel.uiState.value.selectedLeague)
    }
    
    @Test
    fun `selectWeek should update selected week`() = runTest {
        val newWeek = "5. Hafta"
        viewModel.selectWeek(newWeek)
        assertEquals(newWeek, viewModel.uiState.value.selectedWeek)
    }
    
    @Test
    fun `refreshData should load data without errors`() = runTest {
        viewModel.refreshData()
        
        val state = viewModel.uiState.value
        assertFalse(state.isLoading)
        assertEquals(null, state.error)
        assert(state.matches.isNotEmpty())
        assert(state.standings.isNotEmpty())
    }
    
    @Test
    fun `initial state should have default league and week`() = runTest {
        val state = viewModel.uiState.value
        assertEquals("Spor Toto Süper Lig", state.selectedLeague)
        assertEquals("3. Hafta", state.selectedWeek)
    }
    
    @Test
    fun `initial state should have mock data`() = runTest {
        val state = viewModel.uiState.value
        assertEquals(MockData.sampleMatches.size, state.matches.size)
        assertEquals(MockData.sampleStandings.size, state.standings.size)
    }
}
