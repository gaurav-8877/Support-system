package com.riseconnect.repository;

import com.riseconnect.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    
    Optional<Player> findByEmail(String email);
    
    List<Player> findByNameContainingIgnoreCase(String name);
    
    List<Player> findBySportIgnoreCase(String sport);
    
    List<Player> findBySkillLevelIgnoreCase(String skillLevel);
    
    @Query("{'name': {$regex: ?0, $options: 'i'}}")
    List<Player> searchByName(String name);
    
    @Query("{'sport': {$regex: ?0, $options: 'i'}}")
    List<Player> searchBySport(String sport);
    
    @Query("{'skillLevel': {$regex: ?0, $options: 'i'}}")
    List<Player> searchBySkillLevel(String skillLevel);
}
