package com.riseconnect.controller;

import com.riseconnect.model.Player;
import com.riseconnect.repo.InMemoryStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final InMemoryStore store;

    public PlayerController(InMemoryStore store) { this.store = store; }

    @GetMapping
    public List<Player> all() { return store.listPlayers(); }

    @GetMapping("/{id}")
    public ResponseEntity<Player> get(@PathVariable Long id) { return store.getPlayer(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }

    @PostMapping
    public Player create(@RequestBody Player player) { return store.createPlayer(player); }

    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@PathVariable Long id, @RequestBody Player player) { return store.updatePlayer(id, player).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { return store.deletePlayer(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }

    @GetMapping("/search")
    public List<Player> search(@RequestParam String name) { return store.searchPlayersByName(name); }

    @GetMapping("/sport/{sport}")
    public List<Player> bySport(@PathVariable String sport) { return store.playersBySport(sport); }

    @GetMapping("/skill/{level}")
    public List<Player> bySkill(@PathVariable("level") String level) { return store.playersBySkill(level); }
}


