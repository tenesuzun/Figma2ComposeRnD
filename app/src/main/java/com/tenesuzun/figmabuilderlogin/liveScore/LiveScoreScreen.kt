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
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LiveScoreScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        SportsFixtureCard()
    }
}

@Composable
fun SportsFixtureCard() {
    var selectedTabIndex by remember { mutableIntStateOf(1) }
    
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
            CustomTabRow(
                selectedTabIndex = selectedTabIndex,
                onTabSelected = { selectedTabIndex = it }
            )
            
            if (selectedTabIndex == 0) {
                // Puan Durumu (Standings)
                StandingsContent()
            } else {
                // Fikstür (Fixtures)
                FixturesContent()
            }
        }
    }
}

@Composable
fun StandingsContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        
        // League Dropdown
        DropdownChip(
            text = "Spor Toto Süper Lig",
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(10.dp))
        
        // Standings Table
        Box(modifier = Modifier.weight(1f)) {
            StandingsTable(standings = MockData.sampleStandings)
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
                .clickable { /* Handle click */ }
        )
    }
}

@Composable
fun FixturesContent() {
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
            DropdownChip(
                text = "Spor Toto Süper Lig",
                modifier = Modifier.weight(1f)
            )
            
            Spacer(modifier = Modifier.width(12.dp))
            
            DropdownChip(
                text = "3. Hafta",
                modifier = Modifier.width(94.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(10.dp))
        
        // Fixtures List
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Group matches by date
            val groupedMatches = MockData.sampleMatches.groupBy { it.date }
            
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
                .clickable { /* Handle click */ }
        )
    }
}

@Composable
fun CustomTabRow(
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
fun DropdownChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(30.dp)
            .background(
                color = LiveScoreColors.SporLight,
                shape = RoundedCornerShape(4.dp)
            )
            .clickable { /* Handle dropdown click */ }
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

@Composable
fun MatchDate(date: String) {
    Text(
        text = date,
        color = LiveScoreColors.Dark.copy(alpha = 0.6f),
        fontSize = 11.sp,
        textAlign = TextAlign.End,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MatchRow(
    homeTeam: String,
    awayTeam: String,
    score: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(26.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Home Team
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.width(106.dp)
        ) {
            Text(
                text = homeTeam,
                color = LiveScoreColors.Dark,
                fontSize = 12.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.weight(1f)
            )
            
            Spacer(modifier = Modifier.width(6.dp))
            
            TeamLogo()
        }
        
        Spacer(modifier = Modifier.width(6.dp))
        
        // Score
        Box(
            modifier = Modifier
                .background(
                    color = LiveScoreColors.Dark,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(horizontal = 4.dp, vertical = 2.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = score,
                color = LiveScoreColors.White,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
        
        Spacer(modifier = Modifier.width(6.dp))
        
        // Away Team
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(106.dp)
        ) {
            TeamLogo()
            
            Spacer(modifier = Modifier.width(6.dp))
            
            Text(
                text = awayTeam,
                color = LiveScoreColors.Dark,
                fontSize = 12.sp,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun TeamLogo() {
    Box(
        modifier = Modifier
            .size(16.dp)
            .clip(CircleShape)
            .background(Color(0xFFE0E0E0)),
        contentAlignment = Alignment.Center
    ) {
        // Placeholder for team logo
        // In a real app, you would load the actual team logo here
    }
}

@Preview(showBackground = true)
@Composable
fun LiveScoreScreenPreview() {
    LiveScoreScreen()
}

@Preview
@Composable
fun SportsFixtureCardPreview() {
    SportsFixtureCard()
}
