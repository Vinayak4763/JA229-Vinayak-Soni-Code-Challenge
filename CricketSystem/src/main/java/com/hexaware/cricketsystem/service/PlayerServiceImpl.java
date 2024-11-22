package com.hexaware.cricketsystem.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketsystem.entities.Player;
import com.hexaware.cricketsystem.exceptions.PlayerNotFoundException;
import com.hexaware.cricketsystem.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service    //for being service bean//
@Transactional   
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

    // Register a new player
    @Override
    public Player registerPlayer(Player player) {
        return playerRepository.save(player);
    }

    // Update an existing player's information
    @Override
    public Player updatePlayerInfo(Long playerId, Player player) {
        // Check if the player exists before updating
        if (playerRepository.existsById(playerId)) {
            player.setPlayerId(playerId);  // Set the ID to the player (if needed)
            return playerRepository.save(player);
        }
        throw new PlayerNotFoundException("Player not found with id: " + playerId);
    }

    // Get all players
    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Get a player by ID
    @Override
    public Player getPlayerById(Long playerId) throws PlayerNotFoundException {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + playerId));
    }

    // Delete a player by ID
    @Override
    public int deletePlayer(Long playerId) {
        try {
            if (!playerRepository.existsById(playerId)) {
                throw new PlayerNotFoundException("Player not found with id: " + playerId);
            }
            playerRepository.deleteById(playerId);
            return 1; // Return 1 if player is successfully deleted
        } catch (PlayerNotFoundException ex) {
            logger.error(ex.getMessage());
            return 0; // Return 0 if player not found
        }
    }

	@Override
	public List<Player> getPlayerByMatch() {
		
		return playerRepository.findPlayerWithSecondHighestMatches();
	}
    
    
}
