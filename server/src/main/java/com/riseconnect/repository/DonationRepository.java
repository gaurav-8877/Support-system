package com.riseconnect.repository;

import com.riseconnect.model.Donation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends MongoRepository<Donation, String> {
    
    List<Donation> findByCampaignId(String campaignId);
    
    @Query("{'donorName': {$regex: ?0, $options: 'i'}}")
    List<Donation> findByDonorNameContaining(String donorName);
    
    @Query("{'campaignId': ?0}")
    List<Donation> findAllByCampaignId(String campaignId);
}
