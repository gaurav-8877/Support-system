package com.riseconnect.repository;

import com.riseconnect.model.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends MongoRepository<Campaign, String> {
    
    List<Campaign> findByStatus(String status);
    
    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    List<Campaign> searchByTitle(String title);
    
    @Query("{'status': 'ACTIVE'}")
    List<Campaign> findActiveCampaigns();
    
    @Query("{'status': 'COMPLETED'}")
    List<Campaign> findCompletedCampaigns();
}
