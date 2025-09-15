package com.riseconnect.service;

import com.riseconnect.model.Player;
import com.riseconnect.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    
    public Optional<Player> getPlayerById(String id) {
        return playerRepository.findById(id);
    }
    
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }
    
    public Player updatePlayer(String id, Player playerDetails) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            player.setName(playerDetails.getName());
            player.setEmail(playerDetails.getEmail());
            player.setPhone(playerDetails.getPhone());
            player.setAddress(playerDetails.getAddress());
            player.setSport(playerDetails.getSport());
            player.setSkillLevel(playerDetails.getSkillLevel());
            player.setBackgroundStory(playerDetails.getBackgroundStory());
            return playerRepository.save(player);
        }
        return null;
    }
    
    public void deletePlayer(String id) {
        playerRepository.deleteById(id);
    }
    
    public List<Player> searchPlayersByName(String name) {
        return playerRepository.searchByName(name);
    }
    
    public List<Player> getPlayersBySport(String sport) {
        return playerRepository.searchBySport(sport);
    }
    
    public List<Player> getPlayersBySkillLevel(String skillLevel) {
        return playerRepository.searchBySkillLevel(skillLevel);
    }
}
