package com.riseconnect.service;

import com.riseconnect.model.Campaign;
import com.riseconnect.model.Donation;
import com.riseconnect.repository.CampaignRepository;
import com.riseconnect.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {
    
    @Autowired
    private CampaignRepository campaignRepository;
    
    @Autowired
    private DonationRepository donationRepository;
    
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
    
    public Optional<Campaign> getCampaignById(String id) {
        return campaignRepository.findById(id);
    }
    
    public Campaign createCampaign(Campaign campaign) {
        campaign.setCreatedAt(LocalDateTime.now());
        campaign.setUpdatedAt(LocalDateTime.now());
        campaign.setStatus("ACTIVE");
        if (campaign.getRaisedAmount() == null) {
            campaign.setRaisedAmount(BigDecimal.ZERO);
        }
        return campaignRepository.save(campaign);
    }
    
    public Campaign updateCampaign(String id, Campaign campaignDetails) {
        Optional<Campaign> optionalCampaign = campaignRepository.findById(id);
        if (optionalCampaign.isPresent()) {
            Campaign campaign = optionalCampaign.get();
            campaign.setTitle(campaignDetails.getTitle());
            campaign.setDescription(campaignDetails.getDescription());
            campaign.setGoalAmount(campaignDetails.getGoalAmount());
            campaign.setUpdatedAt(LocalDateTime.now());
            return campaignRepository.save(campaign);
        }
        return null;
    }
    
    public void deleteCampaign(String id) {
        campaignRepository.deleteById(id);
    }
    
    public Donation makeDonation(String campaignId, Donation donation) {
        Optional<Campaign> optionalCampaign = campaignRepository.findById(campaignId);
        if (optionalCampaign.isPresent()) {
            Campaign campaign = optionalCampaign.get();
            donation.setCampaignId(campaignId);
            donation.setCreatedAt(LocalDateTime.now());
            
            Donation savedDonation = donationRepository.save(donation);
            
            // Update campaign raised amount
            BigDecimal currentRaised = campaign.getRaisedAmount();
            BigDecimal newRaised = currentRaised.add(donation.getAmount());
            campaign.setRaisedAmount(newRaised);
            campaign.setUpdatedAt(LocalDateTime.now());
            
            // Check if goal is reached
            if (newRaised.compareTo(campaign.getGoalAmount()) >= 0) {
                campaign.setStatus("COMPLETED");
            }
            
            campaignRepository.save(campaign);
            return savedDonation;
        }
        return null;
    }
    
    public List<Donation> getCampaignDonations(String campaignId) {
        return donationRepository.findByCampaignId(campaignId);
    }
    
    public List<Campaign> getActiveCampaigns() {
        return campaignRepository.findActiveCampaigns();
    }
}
