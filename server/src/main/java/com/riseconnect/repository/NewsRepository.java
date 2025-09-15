package com.riseconnect.repository;

import com.riseconnect.model.NewsItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends MongoRepository<NewsItem, String> {
    
    List<NewsItem> findByPublishedTrue();
    
    List<NewsItem> findByCategory(String category);
    
    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    List<NewsItem> searchByTitle(String title);
    
    @Query("{'content': {$regex: ?0, $options: 'i'}}")
    List<NewsItem> searchByContent(String content);
    
    @Query("{'published': true}")
    List<NewsItem> findPublishedNews();
}
