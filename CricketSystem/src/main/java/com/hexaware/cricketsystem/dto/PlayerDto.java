package com.hexaware.cricketsystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Player")
public class PlayerDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @Column(name = "playerName")
    private String playerName;

    private Integer jerseyNumber;
    private String role;
    private int totalMatches;
    private String teamName;
    private String countryStateName;
    private String description;

    public PlayerDto() {
        super();
    }

    public PlayerDto(Long playerId, String playerName, Integer jerseyNumber, String role, int totalMatches, String teamName, String countryStateName, String description) {
        super();
        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        this.totalMatches = totalMatches;
        this.teamName = teamName;
        this.countryStateName = countryStateName;
        this.description = description;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountryStateName() {
        return countryStateName;
    }

    public void setCountryStateName(String countryStateName) {
        this.countryStateName = countryStateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Player [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber 
                + ", role=" + role + ", totalMatches=" + totalMatches + ", teamName=" + teamName 
                + ", countryStateName=" + countryStateName + ", description=" + description + "]";
    }
}

