package com.riseconnect.controller;

import com.riseconnect.model.Campaign;
import com.riseconnect.model.Donation;
import com.riseconnect.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/crowdfunding")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class CrowdfundingController {
    
    @Autowired
    private CampaignService campaignService;

    @GetMapping("/campaigns")
    public List<Campaign> listCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/campaigns/{id}")
    public ResponseEntity<Campaign> getCampaign(@PathVariable String id) {
        Optional<Campaign> campaign = campaignService.getCampaignById(id);
        return campaign.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/campaigns")
    public Campaign createCampaign(@Valid @RequestBody Campaign campaign) {
        return campaignService.createCampaign(campaign);
    }

    @PutMapping("/campaigns/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable String id, @Valid @RequestBody Campaign campaign) {
        Campaign updatedCampaign = campaignService.updateCampaign(id, campaign);
        return updatedCampaign != null ? ResponseEntity.ok(updatedCampaign) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/campaigns/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable String id) {
        campaignService.deleteCampaign(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/campaigns/{id}/donations")
    public List<Donation> listDonations(@PathVariable String id) {
        return campaignService.getCampaignDonations(id);
    }

    @PostMapping("/campaigns/{id}/donations")
    public ResponseEntity<Donation> donate(@PathVariable String id, @Valid @RequestBody Donation donation) {
        Donation savedDonation = campaignService.makeDonation(id, donation);
        return savedDonation != null ? ResponseEntity.ok(savedDonation) : ResponseEntity.notFound().build();
    }

    @GetMapping("/campaigns/active")
    public List<Campaign> getActiveCampaigns() {
        return campaignService.getActiveCampaigns();
    }
}