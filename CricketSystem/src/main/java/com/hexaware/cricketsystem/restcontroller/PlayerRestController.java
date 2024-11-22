package com.hexaware.cricketsystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.cricketsystem.entities.Player;
import com.hexaware.cricketsystem.exceptions.PlayerNotFoundException;
import com.hexaware.cricketsystem.service.IPlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {

    @Autowired
    private IPlayerService playerService;

    // Register a new player
    @PostMapping("/register")
    public ResponseEntity<Player> registerPlayer(@Valid @RequestBody Player player) {
        Player registeredPlayer = playerService.registerPlayer(player);
        return new ResponseEntity<>(registeredPlayer, HttpStatus.CREATED);
    }

    // Update player information
    @PutMapping("/update/{playerId}")
    public ResponseEntity<Player> updatePlayerInfo(@PathVariable Long playerId, @Valid @RequestBody Player player) {
        try {
            Player updatedPlayer = playerService.updatePlayerInfo(playerId, player);
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } catch (PlayerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all players
    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    // Get a player by ID
    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId) {
        try {
            Player player = playerService.getPlayerById(playerId);
            return new ResponseEntity<>(player, HttpStatus.OK);
        } catch (PlayerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a player by ID
    @DeleteMapping("/delete/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long playerId) {
        int result = playerService.deletePlayer(playerId);
        if (result == 1) {
            return new ResponseEntity<>("Player deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Player not found.", HttpStatus.NOT_FOUND);
        }
    }
}
