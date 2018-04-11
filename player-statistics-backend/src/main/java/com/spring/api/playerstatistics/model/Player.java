package com.spring.api.playerstatistics.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Player {
    @Id
    private long playerId;
    private long ranking;
    private long seasonId;
    private String seasonName;
    private long tournamentId;
    private long tournamentRegionId;
    private String tournamentRegionCode;
    private String regionCode;
    private String tournamentName;
    private String tournamentShortName;
    private String firstName;
    private String lastName	;
    private boolean isActive;	
    private boolean isOpta;
    private long teamId;	
    private String teamName	;
    private String playedPositions;
    private int age;
    private int height;
    private int weight;
    private String positionText;
    private int apps;
    private int subOn;
    private long minsPlayed	;
    private float rating;
    private int goal;
    private int assistTotal;
    private int yellowCard;
    private int redCard;
    private float shotsPerGame;
    private float aerialWonPerGame;
    private int manOfTheMatch;
    private String name;
    private int isManOfTheMatch	;
    private String playedPositionsShort;
    private float passSuccess;
}
