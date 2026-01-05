package com.tenesuzun.figmabuilderlogin.liveScore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StandingsTable(standings: List<Standing>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        
        // Header
        StandingsHeader()
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Standings rows
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(standings) { standing ->
                StandingRow(standing)
            }
        }
    }
}

@Composable
fun StandingsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .background(LiveScoreColors.SporLight),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "S",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = LiveScoreColors.Spor,
                modifier = Modifier
                    .width(30.dp)
                    .padding(start = 8.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Takım",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = LiveScoreColors.Spor,
                modifier = Modifier.weight(1f)
            )
        }
        
        Row(
            modifier = Modifier.width(140.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            HeaderCell("O")
            HeaderCell("G")
            HeaderCell("B")
            HeaderCell("M")
            HeaderCell("A")
            HeaderCell("P")
        }
    }
}

@Composable
fun HeaderCell(text: String) {
    Text(
        text = text,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        color = LiveScoreColors.Spor,
        textAlign = TextAlign.Center,
        modifier = Modifier.width(20.dp)
    )
}

@Composable
fun StandingRow(standing: Standing) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Position
            Text(
                text = standing.position.toString(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = LiveScoreColors.Dark,
                modifier = Modifier
                    .width(30.dp)
                    .padding(start = 8.dp),
                textAlign = TextAlign.Center
            )
            
            // Team Logo
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE0E0E0))
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            // Team Name
            Text(
                text = standing.team.name,
                fontSize = 12.sp,
                color = LiveScoreColors.Dark,
                modifier = Modifier.weight(1f)
            )
        }
        
        Row(
            modifier = Modifier.width(140.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StandingCell(standing.played.toString())
            StandingCell(standing.won.toString())
            StandingCell(standing.drawn.toString())
            StandingCell(standing.lost.toString())
            StandingCell(standing.goalDifference.toString())
            StandingCell(standing.points.toString(), isPoints = true)
        }
    }
}

@Composable
fun StandingCell(text: String, isPoints: Boolean = false) {
    Text(
        text = text,
        fontSize = 11.sp,
        fontWeight = if (isPoints) FontWeight.Bold else FontWeight.Normal,
        color = LiveScoreColors.Dark,
        textAlign = TextAlign.Center,
        modifier = Modifier.width(20.dp)
    )
}
