package com.riseconnect.controller;

import com.riseconnect.model.Mentorship;
import com.riseconnect.repo.InMemoryStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentorships")
public class MentorshipController {
    private final InMemoryStore store;

    public MentorshipController(InMemoryStore store) { this.store = store; }

    @GetMapping
    public List<Mentorship> list() { return store.listMentorships(); }

    @PostMapping
    public Mentorship create(@RequestBody Mentorship m) { return store.createMentorship(m); }

    @PutMapping("/{id}")
    public ResponseEntity<Mentorship> update(@PathVariable Long id, @RequestBody Mentorship m) { return store.updateMentorship(id, m).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { return store.deleteMentorship(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
}


