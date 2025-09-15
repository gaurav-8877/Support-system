package com.riseconnect.controller;

import com.riseconnect.model.Campaign;
import com.riseconnect.model.Donation;
import com.riseconnect.repo.InMemoryStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crowdfunding")
public class CrowdfundingController {
    private final InMemoryStore store;

    public CrowdfundingController(InMemoryStore store) { this.store = store; }

    @GetMapping("/campaigns")
    public List<Campaign> listCampaigns() { return store.listCampaigns(); }

    @PostMapping("/campaigns")
    public Campaign createCampaign(@RequestBody Campaign c) { return store.createCampaign(c); }

    @GetMapping("/campaigns/{id}/donations")
    public List<Donation> listDonations(@PathVariable Long id) { return store.listDonations(id); }

    @PostMapping("/campaigns/{id}/donations")
    public ResponseEntity<Donation> donate(@PathVariable Long id, @RequestBody Donation d) {
        return store.getCampaign(id).map(c -> ResponseEntity.ok(store.donate(id, d))).orElse(ResponseEntity.notFound().build());
    }
}


