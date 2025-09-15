package com.riseconnect.controller;

import com.riseconnect.model.Player;
import com.riseconnect.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable String id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Player createPlayer(@Valid @RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable String id, @Valid @RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(id, player);
        return updatedPlayer != null ? ResponseEntity.ok(updatedPlayer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Player> searchPlayersByName(@RequestParam String name) {
        return playerService.searchPlayersByName(name);
    }

    @GetMapping("/sport/{sport}")
    public List<Player> getPlayersBySport(@PathVariable String sport) {
        return playerService.getPlayersBySport(sport);
    }

    @GetMapping("/skill/{level}")
    public List<Player> getPlayersBySkillLevel(@PathVariable("level") String level) {
        return playerService.getPlayersBySkillLevel(level);
    }
}