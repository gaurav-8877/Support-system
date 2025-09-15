package com.riseconnect.model;

public class Mentorship {
    private Long id;
    private String mentorName;
    private String menteeName;
    private String goals;
    private String status; // ACTIVE | COMPLETED | PENDING

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMentorName() { return mentorName; }
    public void setMentorName(String mentorName) { this.mentorName = mentorName; }
    public String getMenteeName() { return menteeName; }
    public void setMenteeName(String menteeName) { this.menteeName = menteeName; }
    public String getGoals() { return goals; }
    public void setGoals(String goals) { this.goals = goals; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}


