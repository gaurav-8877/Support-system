package com.riseconnect.service;

import com.riseconnect.model.Mentorship;
import com.riseconnect.repository.MentorshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MentorshipService {
    
    @Autowired
    private MentorshipRepository mentorshipRepository;
    
    public List<Mentorship> getAllMentorships() {
        return mentorshipRepository.findAll();
    }
    
    public Optional<Mentorship> getMentorshipById(String id) {
        return mentorshipRepository.findById(id);
    }
    
    public Mentorship createMentorship(Mentorship mentorship) {
        mentorship.setCreatedAt(LocalDateTime.now());
        mentorship.setUpdatedAt(LocalDateTime.now());
        if (mentorship.getStatus() == null) {
            mentorship.setStatus("PENDING");
        }
        return mentorshipRepository.save(mentorship);
    }
    
    public Mentorship updateMentorship(String id, Mentorship mentorshipDetails) {
        Optional<Mentorship> optionalMentorship = mentorshipRepository.findById(id);
        if (optionalMentorship.isPresent()) {
            Mentorship mentorship = optionalMentorship.get();
            mentorship.setMentorName(mentorshipDetails.getMentorName());
            mentorship.setMenteeName(mentorshipDetails.getMenteeName());
            mentorship.setGoals(mentorshipDetails.getGoals());
            mentorship.setStatus(mentorshipDetails.getStatus());
            mentorship.setUpdatedAt(LocalDateTime.now());
            
            // Set start date if status is changing to ACTIVE
            if ("ACTIVE".equals(mentorshipDetails.getStatus()) && mentorship.getStartDate() == null) {
                mentorship.setStartDate(LocalDateTime.now());
            }
            
            // Set end date if status is changing to COMPLETED
            if ("COMPLETED".equals(mentorshipDetails.getStatus()) && mentorship.getEndDate() == null) {
                mentorship.setEndDate(LocalDateTime.now());
            }
            
            return mentorshipRepository.save(mentorship);
        }
        return null;
    }
    
    public void deleteMentorship(String id) {
        mentorshipRepository.deleteById(id);
    }
    
    public List<Mentorship> getMentorshipsByStatus(String status) {
        return mentorshipRepository.findByStatus(status);
    }
    
    public List<Mentorship> searchByMentorName(String mentorName) {
        return mentorshipRepository.searchByMentorName(mentorName);
    }
    
    public List<Mentorship> searchByMenteeName(String menteeName) {
        return mentorshipRepository.searchByMenteeName(menteeName);
    }
}
