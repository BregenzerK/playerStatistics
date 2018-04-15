package com.spring.api.playerstatistics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "players")
public class Player {
    private long ranking;
    @Column(name = "season_id")
    private long seasonId;
    @Column(name = "season_name")
    private String seasonName;
    @Column(name = "tournament_id")
    private long tournamentId;
    @Column(name = "tournament_region_id")
    private long tournamentRegionId;
    @Column(name = "tournament_region_code")
    private String tournamentRegionCode;
    @Column(name = "region_code")
    private String regionCode;
    @Column(name = "tournament_name")
    private String tournamentName;
    @Column(name = "tournament_short_name")
    private String tournamentShortName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName	;
    @Id
    @Column(name = "player_id")
    private long playerId;
    private boolean active;
    private boolean opta;
    @Column(name = "team_id")
    private long teamId;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "played_positions")
    private String playedPositions;
    private int age;
    private int height;
    private int weight;
    @Column(name = "position_text")
    private String positionText;
    private int apps;
    @Column(name = "sub_on")
    private int subOn;
    @Column(name = "mins_played")
    private long minsPlayed;
    private float rating;
    private int goal;
    @Column(name = "assist_total")
    private int assistTotal;
    @Column(name = "yellow_card")
    private int yellowCard;
    @Column(name = "red_card")
    private int redCard;
    @Column(name = "shots_per_game")
    private float shotsPerGame;
    @Column(name = "aerial_won_per_game")
    private float aerialWonPerGame;
    @Column(name = "man_of_the_match")
    private int manOfTheMatch;
    private String name;
    @Column(name = "player_in_the_match")
    private boolean playerInTheMatch;
    @Column(name = "played_positions_short")
    private String playedPositionsShort;
    @Column(name = "pass_success")
    private float passSuccess;
}
