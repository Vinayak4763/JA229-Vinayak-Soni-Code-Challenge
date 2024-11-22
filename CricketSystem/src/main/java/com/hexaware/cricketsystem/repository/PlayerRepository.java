package com.hexaware.cricketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketsystem.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByPlayerId(long playerId);
    //query for getting player by ID


}
