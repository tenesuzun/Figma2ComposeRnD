package com.tenesuzun.figmabuilderlogin.liveScore

data class Match(
    val id: Int,
    val homeTeam: Team,
    val awayTeam: Team,
    val score: String,
    val date: String,
    val time: String = ""
)

data class Team(
    val name: String,
    val logoUrl: String = ""
)

data class League(
    val name: String,
    val matches: List<Match>
)

data class Standing(
    val position: Int,
    val team: Team,
    val played: Int,
    val won: Int,
    val drawn: Int,
    val lost: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int,
    val points: Int
)

object MockData {
    val sampleTeams = listOf(
        Team("Galatasaray"),
        Team("Fenerbahçe"),
        Team("Beşiktaş"),
        Team("Trabzonspor"),
        Team("Medipol Başakşehir"),
        Team("Adanademirspor"),
        Team("Konyaspor"),
        Team("Sivasspor")
    )
    
    val sampleMatches = listOf(
        Match(
            id = 1,
            homeTeam = Team("Adanademirspor"),
            awayTeam = Team("Adanademirspor"),
            score = "1-0",
            date = "19 Ağustos Cuma"
        ),
        Match(
            id = 2,
            homeTeam = Team("Trabzonspor"),
            awayTeam = Team("Trabzonspor"),
            score = "1-0",
            date = "20 Ağustos Cuma"
        ),
        Match(
            id = 3,
            homeTeam = Team("Fenerbahçe"),
            awayTeam = Team("Fenerbahçe"),
            score = "1-0",
            date = "20 Ağustos Cuma"
        ),
        Match(
            id = 4,
            homeTeam = Team("Medipol Başakşehir"),
            awayTeam = Team("Medipol Başakşehir"),
            score = "1-0",
            date = "20 Ağustos Cuma"
        )
    )
    
    val sampleStandings = listOf(
        Standing(1, Team("Galatasaray"), 3, 3, 0, 0, 8, 2, 6, 9),
        Standing(2, Team("Fenerbahçe"), 3, 2, 1, 0, 6, 2, 4, 7),
        Standing(3, Team("Trabzonspor"), 3, 2, 0, 1, 5, 3, 2, 6),
        Standing(4, Team("Beşiktaş"), 3, 1, 2, 0, 4, 2, 2, 5),
        Standing(5, Team("Başakşehir"), 3, 1, 1, 1, 3, 3, 0, 4),
        Standing(6, Team("Konyaspor"), 3, 1, 0, 2, 3, 5, -2, 3),
        Standing(7, Team("Sivasspor"), 3, 0, 1, 2, 2, 5, -3, 1),
        Standing(8, Team("Adanademirspor"), 3, 0, 0, 3, 1, 10, -9, 0)
    )
}
