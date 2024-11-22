package com.hexaware.cricketsystem.service;

import java.util.List;
import com.hexaware.cricketsystem.entities.Player;

public interface IPlayerService {

    // Method to register a new player
    Player registerPlayer(Player player);

    // Method to update an existing player's information
    Player updatePlayerInfo(Long playerId, Player player);

    // Method to get all players
    List<Player> getAllPlayers();

    // Method to get a player by ID
    Player getPlayerById(Long playerId);

    // Method to delete a player by ID
    int deletePlayer(Long playerId);
}
