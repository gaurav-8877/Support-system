package com.riseconnect.service;

import com.riseconnect.model.NewsItem;
import com.riseconnect.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    
    @Autowired
    private NewsRepository newsRepository;
    
    public List<NewsItem> getAllNews() {
        return newsRepository.findPublishedNews();
    }
    
    public Optional<NewsItem> getNewsById(String id) {
        return newsRepository.findById(id);
    }
    
    public NewsItem createNews(NewsItem newsItem) {
        newsItem.setCreatedAt(LocalDateTime.now());
        newsItem.setUpdatedAt(LocalDateTime.now());
        newsItem.setPublishedAt(LocalDateTime.now());
        newsItem.setPublished(true);
        return newsRepository.save(newsItem);
    }
    
    public NewsItem updateNews(String id, NewsItem newsDetails) {
        Optional<NewsItem> optionalNews = newsRepository.findById(id);
        if (optionalNews.isPresent()) {
            NewsItem newsItem = optionalNews.get();
            newsItem.setTitle(newsDetails.getTitle());
            newsItem.setContent(newsDetails.getContent());
            newsItem.setAuthor(newsDetails.getAuthor());
            newsItem.setCategory(newsDetails.getCategory());
            newsItem.setImageUrl(newsDetails.getImageUrl());
            newsItem.setSummary(newsDetails.getSummary());
            newsItem.setPublished(newsDetails.isPublished());
            newsItem.setUpdatedAt(LocalDateTime.now());
            return newsRepository.save(newsItem);
        }
        return null;
    }
    
    public void deleteNews(String id) {
        newsRepository.deleteById(id);
    }
    
    public List<NewsItem> searchNewsByTitle(String title) {
        return newsRepository.searchByTitle(title);
    }
    
    public List<NewsItem> getNewsByCategory(String category) {
        return newsRepository.findByCategory(category);
    }
}
