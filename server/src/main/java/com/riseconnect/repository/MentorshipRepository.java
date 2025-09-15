package com.riseconnect.repository;

import com.riseconnect.model.Mentorship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorshipRepository extends MongoRepository<Mentorship, String> {
    
    List<Mentorship> findByStatus(String status);
    
    List<Mentorship> findByMentorNameContainingIgnoreCase(String mentorName);
    
    List<Mentorship> findByMenteeNameContainingIgnoreCase(String menteeName);
    
    @Query("{'mentorName': {$regex: ?0, $options: 'i'}}")
    List<Mentorship> searchByMentorName(String mentorName);
    
    @Query("{'menteeName': {$regex: ?0, $options: 'i'}}")
    List<Mentorship> searchByMenteeName(String menteeName);
    
    @Query("{'sport': {$regex: ?0, $options: 'i'}}")
    List<Mentorship> findBySport(String sport);
}
