package com.riseconnect.controller;

import com.riseconnect.model.Mentorship;
import com.riseconnect.service.MentorshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mentorships")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class MentorshipController {
    
    @Autowired
    private MentorshipService mentorshipService;

    @GetMapping
    public List<Mentorship> listMentorships() {
        return mentorshipService.getAllMentorships();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mentorship> getMentorship(@PathVariable String id) {
        Optional<Mentorship> mentorship = mentorshipService.getMentorshipById(id);
        return mentorship.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mentorship createMentorship(@Valid @RequestBody Mentorship mentorship) {
        return mentorshipService.createMentorship(mentorship);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mentorship> updateMentorship(@PathVariable String id, @Valid @RequestBody Mentorship mentorship) {
        Mentorship updatedMentorship = mentorshipService.updateMentorship(id, mentorship);
        return updatedMentorship != null ? ResponseEntity.ok(updatedMentorship) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMentorship(@PathVariable String id) {
        mentorshipService.deleteMentorship(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public List<Mentorship> getMentorshipsByStatus(@PathVariable String status) {
        return mentorshipService.getMentorshipsByStatus(status);
    }

    @GetMapping("/mentor/{mentorName}")
    public List<Mentorship> searchByMentorName(@PathVariable String mentorName) {
        return mentorshipService.searchByMentorName(mentorName);
    }

    @GetMapping("/mentee/{menteeName}")
    public List<Mentorship> searchByMenteeName(@PathVariable String menteeName) {
        return mentorshipService.searchByMenteeName(menteeName);
    }
}