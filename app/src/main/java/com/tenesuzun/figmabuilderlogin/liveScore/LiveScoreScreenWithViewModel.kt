package com.tenesuzun.figmabuilderlogin.liveScore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LiveScoreScreenWithViewModel(
    viewModel: LiveScoreViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        SportsFixtureCardWithViewModel(
            uiState = uiState,
            onTabSelected = { viewModel.selectTab(it) },
            onLeagueSelected = { viewModel.selectLeague(it) },
            onWeekSelected = { viewModel.selectWeek(it) },
            onViewAllClick = { /* Navigate to full list */ }
        )
        
        if (uiState.isLoading) {
            CircularProgressIndicator(
                color = LiveScoreColors.Spor,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun SportsFixtureCardWithViewModel(
    uiState: LiveScoreUiState,
    onTabSelected: (Int) -> Unit,
    onLeagueSelected: (String) -> Unit,
    onWeekSelected: (String) -> Unit,
    onViewAllClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(343.dp)
            .height(285.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = LiveScoreColors.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Tabs Row
            CustomTabRowWithState(
                selectedTabIndex = uiState.selectedTab,
                onTabSelected = onTabSelected
            )
            
            if (uiState.selectedTab == 0) {
                // Puan Durumu (Standings)
                StandingsContentWithState(
                    uiState = uiState,
                    onLeagueSelected = onLeagueSelected,
                    onViewAllClick = onViewAllClick
                )
            } else {
                // Fikstür (Fixtures)
                FixturesContentWithState(
                    uiState = uiState,
                    onLeagueSelected = onLeagueSelected,
                    onWeekSelected = onWeekSelected,
                    onViewAllClick = onViewAllClick
                )
            }
        }
    }
}

@Composable
fun StandingsContentWithState(
    uiState: LiveScoreUiState,
    onLeagueSelected: (String) -> Unit,
    onViewAllClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        
        // League Dropdown
        DropdownChipWithState(
            text = uiState.selectedLeague,
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* Show league selector */ }
        )
        
        Spacer(modifier = Modifier.height(10.dp))
        
        // Standings Table
        Box(modifier = Modifier.weight(1f)) {
            StandingsTable(standings = uiState.standings)
        }
        
        // Tüm Liste Link
        Text(
            text = "Tüm Liste",
            color = LiveScoreColors.Ekonomi,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .clickable { onViewAllClick() }
        )
    }
}

@Composable
fun FixturesContentWithState(
    uiState: LiveScoreUiState,
    onLeagueSelected: (String) -> Unit,
    onWeekSelected: (String) -> Unit,
    onViewAllClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        
        // Dropdowns Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DropdownChipWithState(
                text = uiState.selectedLeague,
                modifier = Modifier.weight(1f),
                onClick = { /* Show league selector */ }
            )
            
            Spacer(modifier = Modifier.width(12.dp))
            
            DropdownChipWithState(
                text = uiState.selectedWeek,
                modifier = Modifier.width(94.dp),
                onClick = { /* Show week selector */ }
            )
        }
        
        Spacer(modifier = Modifier.height(10.dp))
        
        // Fixtures List
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Group matches by date
            val groupedMatches = uiState.matches.groupBy { it.date }
            
            groupedMatches.forEach { (date, matches) ->
                MatchDate(date = date)
                Spacer(modifier = Modifier.height(4.dp))
                
                matches.forEach { match ->
                    MatchRow(
                        homeTeam = match.homeTeam.name,
                        awayTeam = match.awayTeam.name,
                        score = match.score
                    )
                    
                    if (match != matches.last()) {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
                
                if (date != groupedMatches.keys.last()) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        // Tüm Liste Link
        Text(
            text = "Tüm Liste",
            color = LiveScoreColors.Ekonomi,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .clickable { onViewAllClick() }
        )
    }
}

@Composable
fun CustomTabRowWithState(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                height = 0.dp,
                color = Color.Transparent
            )
        },
        divider = {}
    ) {
        Tab(
            selected = selectedTabIndex == 0,
            onClick = { onTabSelected(0) },
            modifier = Modifier
                .height(38.dp)
                .background(
                    color = if (selectedTabIndex == 0) LiveScoreColors.Spor else LiveScoreColors.SporLight,
                    shape = RoundedCornerShape(topStart = 12.dp)
                )
        ) {
            Text(
                text = "PUAN DURUMU",
                color = if (selectedTabIndex == 0) LiveScoreColors.White else LiveScoreColors.Spor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        
        Spacer(modifier = Modifier.width(1.dp))
        
        Tab(
            selected = selectedTabIndex == 1,
            onClick = { onTabSelected(1) },
            modifier = Modifier
                .height(38.dp)
                .background(
                    color = if (selectedTabIndex == 1) LiveScoreColors.Spor else LiveScoreColors.SporLight,
                    shape = RoundedCornerShape(topEnd = 12.dp)
                )
        ) {
            Text(
                text = "FİKSTÜR",
                color = if (selectedTabIndex == 1) LiveScoreColors.White else LiveScoreColors.Spor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DropdownChipWithState(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .height(30.dp)
            .background(
                color = LiveScoreColors.SporLight,
                shape = RoundedCornerShape(4.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = LiveScoreColors.Spor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Dropdown",
            tint = LiveScoreColors.Spor,
            modifier = Modifier.size(14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LiveScoreScreenWithViewModelPreview() {
    LiveScoreScreenWithViewModel()
}
