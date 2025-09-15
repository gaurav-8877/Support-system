package com.riseconnect.service;

import com.riseconnect.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class DataInitializationService implements CommandLineRunner {

    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private CampaignService campaignService;
    
    @Autowired
    private MentorshipService mentorshipService;
    
    @Autowired
    private NewsService newsService;

    @Override
    public void run(String... args) throws Exception {
        // Initialize sample data if collections are empty
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Initialize sample players
        if (playerService.getAllPlayers().isEmpty()) {
            createSamplePlayers();
        }

        // Initialize sample campaigns
        if (campaignService.getAllCampaigns().isEmpty()) {
            createSampleCampaigns();
        }

        // Initialize sample mentorships
        if (mentorshipService.getAllMentorships().isEmpty()) {
            createSampleMentorships();
        }

        // Initialize sample news
        if (newsService.getAllNews().isEmpty()) {
            createSampleNews();
        }
    }

    private void createSamplePlayers() {
        Player player1 = new Player();
        player1.setName("Maria Rodriguez");
        player1.setEmail("maria.rodriguez@email.com");
        player1.setPhone("+1-555-0123");
        player1.setAddress("Los Angeles, CA");
        player1.setSport("Soccer");
        player1.setSkillLevel("Advanced");
        player1.setBackgroundStory("Maria grew up in a low-income neighborhood but has always dreamed of playing professional soccer. She needs support to attend training camps and tournaments.");
        playerService.createPlayer(player1);

        Player player2 = new Player();
        player2.setName("James Thompson");
        player2.setEmail("james.thompson@email.com");
        player2.setPhone("+1-555-0456");
        player2.setAddress("Chicago, IL");
        player2.setSport("Basketball");
        player2.setSkillLevel("Intermediate");
        player2.setBackgroundStory("James is a talented basketball player who needs equipment and coaching to reach the next level.");
        playerService.createPlayer(player2);

        Player player3 = new Player();
        player3.setName("Sarah Chen");
        player3.setEmail("sarah.chen@email.com");
        player3.setPhone("+1-555-0789");
        player3.setAddress("Seattle, WA");
        player3.setSport("Tennis");
        player3.setSkillLevel("Beginner");
        player3.setBackgroundStory("Sarah discovered tennis late but shows great potential. She needs basic equipment and lessons to develop her skills.");
        playerService.createPlayer(player3);
    }

    private void createSampleCampaigns() {
        Campaign campaign1 = new Campaign();
        campaign1.setTitle("Support Maria's Soccer Dreams");
        campaign1.setDescription("Help Maria attend elite soccer training camps and compete in national tournaments. She has the talent but needs financial support to reach her potential.");
        campaign1.setGoalAmount(new BigDecimal("5000.00"));
        campaign1.setRaisedAmount(new BigDecimal("1200.00"));
        campaign1.setStatus("ACTIVE");
        campaignService.createCampaign(campaign1);

        Campaign campaign2 = new Campaign();
        campaign2.setTitle("James Basketball Equipment Fund");
        campaign2.setDescription("James needs proper basketball equipment, shoes, and training gear to compete at a higher level. Every contribution helps!");
        campaign2.setGoalAmount(new BigDecimal("2500.00"));
        campaign2.setRaisedAmount(new BigDecimal("800.00"));
        campaign2.setStatus("ACTIVE");
        campaignService.createCampaign(campaign2);

        Campaign campaign3 = new Campaign();
        campaign3.setTitle("Sarah's Tennis Journey");
        campaign3.setDescription("Support Sarah's tennis development with equipment, lessons, and tournament entry fees. Help her discover her full potential!");
        campaign3.setGoalAmount(new BigDecimal("3000.00"));
        campaign3.setRaisedAmount(new BigDecimal("1500.00"));
        campaign3.setStatus("ACTIVE");
        campaignService.createCampaign(campaign3);
    }

    private void createSampleMentorships() {
        Mentorship mentorship1 = new Mentorship();
        mentorship1.setMentorName("Coach Michael Johnson");
        mentorship1.setMenteeName("Maria Rodriguez");
        mentorship1.setGoals("Improve technical skills, develop game strategy, and prepare for college recruitment");
        mentorship1.setStatus("ACTIVE");
        mentorship1.setSport("Soccer");
        mentorship1.setSkillLevel("Advanced");
        mentorshipService.createMentorship(mentorship1);

        Mentorship mentorship2 = new Mentorship();
        mentorship2.setMentorName("Lisa Williams");
        mentorship2.setMenteeName("James Thompson");
        mentorship2.setGoals("Develop shooting technique, improve court awareness, and build confidence");
        mentorship2.setStatus("PENDING");
        mentorship2.setSport("Basketball");
        mentorship2.setSkillLevel("Intermediate");
        mentorshipService.createMentorship(mentorship2);

        Mentorship mentorship3 = new Mentorship();
        mentorship3.setMentorName("David Park");
        mentorship3.setMenteeName("Sarah Chen");
        mentorship3.setGoals("Learn basic techniques, develop consistency, and understand match strategy");
        mentorship3.setStatus("ACTIVE");
        mentorship3.setSport("Tennis");
        mentorship3.setSkillLevel("Beginner");
        mentorshipService.createMentorship(mentorship3);
    }

    private void createSampleNews() {
        NewsItem news1 = new NewsItem();
        news1.setTitle("Maria Rodriguez Wins Regional Soccer Championship");
        news1.setContent("Maria Rodriguez, one of our supported athletes, has won the regional soccer championship! Her dedication and the support from our community made this achievement possible. She's now being scouted by several college programs.");
        news1.setAuthor("Rise Connect Team");
        news1.setCategory("Success Stories");
        news1.setSummary("Maria Rodriguez wins regional soccer championship with community support");
        newsService.createNews(news1);

        NewsItem news2 = new NewsItem();
        news2.setTitle("New Mentorship Program Launches");
        news2.setContent("We're excited to announce the launch of our enhanced mentorship program, connecting experienced athletes and coaches with up-and-coming talent. The program has already matched 50+ mentor-mentee pairs.");
        news2.setAuthor("Rise Connect Team");
        news2.setCategory("Program Updates");
        news2.setSummary("Enhanced mentorship program launches with 50+ successful matches");
        newsService.createNews(news2);

        NewsItem news3 = new NewsItem();
        news3.setTitle("Community Raises $100K for Athletes in Need");
        news3.setContent("Thanks to the incredible generosity of our community, we've raised over $100,000 to support underprivileged athletes. These funds will help cover equipment, training, and competition costs for dozens of talented individuals.");
        news3.setAuthor("Rise Connect Team");
        news3.setCategory("Fundraising");
        news3.setSummary("Community raises $100K to support underprivileged athletes");
        newsService.createNews(news3);
    }
}
