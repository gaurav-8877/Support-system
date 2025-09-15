package com.riseconnect.repo;

import com.riseconnect.model.*;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component
public class InMemoryStore {
    private final Map<Long, Player> players = new ConcurrentHashMap<>();
    private final Map<Long, Mentorship> mentorships = new ConcurrentHashMap<>();
    private final Map<Long, Campaign> campaigns = new ConcurrentHashMap<>();
    private final Map<Long, List<Donation>> campaignDonations = new ConcurrentHashMap<>();
    private final Map<Long, NewsItem> news = new ConcurrentHashMap<>();

    private final AtomicLong seq = new AtomicLong(1);

    public InMemoryStore() {
        // seed some data
        Player p = new Player();
        p.setId(seq.getAndIncrement());
        p.setName("Jane Doe");
        p.setSport("Basketball");
        p.setSkillLevel("Intermediate");
        players.put(p.getId(), p);

        NewsItem n = new NewsItem();
        n.setId(seq.getAndIncrement());
        n.setTitle("Welcome to Rise Connect");
        n.setContent("Platform launched successfully.");
        n.setPublishedAt(Instant.now());
        news.put(n.getId(), n);

        Campaign c = new Campaign();
        c.setId(seq.getAndIncrement());
        c.setTitle("Training Gear");
        c.setDescription("Help fund new training equipment.");
        c.setGoalAmount(new BigDecimal("5000"));
        c.setRaisedAmount(new BigDecimal("0"));
        campaigns.put(c.getId(), c);
        campaignDonations.put(c.getId(), new ArrayList<>());
    }

    private Long nextId() { return seq.getAndIncrement(); }

    // Players
    public List<Player> listPlayers() { return new ArrayList<>(players.values()); }
    public Optional<Player> getPlayer(Long id) { return Optional.ofNullable(players.get(id)); }
    public Player createPlayer(Player player) { player.setId(nextId()); players.put(player.getId(), player); return player; }
    public Optional<Player> updatePlayer(Long id, Player p) { if (!players.containsKey(id)) return Optional.empty(); p.setId(id); players.put(id, p); return Optional.of(p);} 
    public boolean deletePlayer(Long id) { return players.remove(id) != null; }
    public List<Player> searchPlayersByName(String name) { return players.values().stream().filter(pl -> pl.getName()!=null && pl.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList()); }
    public List<Player> playersBySport(String sport) { return players.values().stream().filter(pl -> Objects.equals(pl.getSport(), sport)).collect(Collectors.toList()); }
    public List<Player> playersBySkill(String skill) { return players.values().stream().filter(pl -> Objects.equals(pl.getSkillLevel(), skill)).collect(Collectors.toList()); }

    // Mentorships
    public List<Mentorship> listMentorships() { return new ArrayList<>(mentorships.values()); }
    public Mentorship createMentorship(Mentorship m) { m.setId(nextId()); mentorships.put(m.getId(), m); return m; }
    public Optional<Mentorship> updateMentorship(Long id, Mentorship m) { if (!mentorships.containsKey(id)) return Optional.empty(); m.setId(id); mentorships.put(id, m); return Optional.of(m);} 
    public boolean deleteMentorship(Long id) { return mentorships.remove(id) != null; }

    // Campaigns
    public List<Campaign> listCampaigns() { return new ArrayList<>(campaigns.values()); }
    public Campaign createCampaign(Campaign c) { c.setId(nextId()); if (c.getRaisedAmount()==null) c.setRaisedAmount(BigDecimal.ZERO); campaigns.put(c.getId(), c); campaignDonations.put(c.getId(), new ArrayList<>()); return c; }
    public Optional<Campaign> getCampaign(Long id) { return Optional.ofNullable(campaigns.get(id)); }
    public Donation donate(Long campaignId, Donation donation) { donation.setId(nextId()); campaignDonations.computeIfAbsent(campaignId, k -> new ArrayList<>()).add(donation); Campaign c = campaigns.get(campaignId); if (c != null && donation.getAmount()!=null) { c.setRaisedAmount(c.getRaisedAmount().add(donation.getAmount())); } return donation; }
    public List<Donation> listDonations(Long campaignId) { return new ArrayList<>(campaignDonations.getOrDefault(campaignId, List.of())); }

    // News
    public List<NewsItem> listNews() { return new ArrayList<>(news.values()); }
    public NewsItem createNews(NewsItem item) { item.setId(nextId()); if (item.getPublishedAt()==null) item.setPublishedAt(Instant.now()); news.put(item.getId(), item); return item; }
    public boolean deleteNews(Long id) { return news.remove(id) != null; }
}


