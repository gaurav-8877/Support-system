package com.riseconnect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Document(collection = "mentorships")
public class Mentorship {
    @Id
    private String id;
    
    @NotBlank(message = "Mentor name is required")
    @Size(min = 2, max = 100, message = "Mentor name must be between 2 and 100 characters")
    private String mentorName;
    
    @NotBlank(message = "Mentee name is required")
    @Size(min = 2, max = 100, message = "Mentee name must be between 2 and 100 characters")
    private String menteeName;
    
    @NotBlank(message = "Goals are required")
    @Size(min = 10, max = 1000, message = "Goals must be between 10 and 1000 characters")
    private String goals;
    
    @Pattern(regexp = "ACTIVE|COMPLETED|PENDING", message = "Status must be ACTIVE, COMPLETED, or PENDING")
    private String status = "PENDING";
    
    @Field("created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Field("updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    @Field("start_date")
    private LocalDateTime startDate;
    
    @Field("end_date")
    private LocalDateTime endDate;
    
    private String mentorEmail;
    private String menteeEmail;
    private String sport;
    private String skillLevel;

    public Mentorship() {}

    public Mentorship(String mentorName, String menteeName, String goals, String status) {
        this.mentorName = mentorName;
        this.menteeName = menteeName;
        this.goals = goals;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMenteeName() {
        return menteeName;
    }

    public void setMenteeName(String menteeName) {
        this.menteeName = menteeName;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }

    public String getMenteeEmail() {
        return menteeEmail;
    }

    public void setMenteeEmail(String menteeEmail) {
        this.menteeEmail = menteeEmail;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }
}