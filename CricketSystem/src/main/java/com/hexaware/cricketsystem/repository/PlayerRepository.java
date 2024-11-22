package com.hexaware.cricketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.cricketsystem.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    
    @Query("SELECT p FROM Player p WHERE p.totalMatches = (" +
           "SELECT MAX(p2.totalMatches) FROM Player p2 WHERE p2.totalMatches < (SELECT MAX(p3.totalMatches) FROM Player p3))")
    List<Player> findPlayerWithSecondHighestMatches();

}
