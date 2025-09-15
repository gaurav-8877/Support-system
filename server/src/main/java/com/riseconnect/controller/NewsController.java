package com.riseconnect.controller;

import com.riseconnect.model.NewsItem;
import com.riseconnect.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class NewsController {
    
    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<NewsItem> listNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsItem> getNews(@PathVariable String id) {
        Optional<NewsItem> newsItem = newsService.getNewsById(id);
        return newsItem.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NewsItem createNews(@Valid @RequestBody NewsItem newsItem) {
        return newsService.createNews(newsItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsItem> updateNews(@PathVariable String id, @Valid @RequestBody NewsItem newsItem) {
        NewsItem updatedNews = newsService.updateNews(id, newsItem);
        return updatedNews != null ? ResponseEntity.ok(updatedNews) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable String id) {
        newsService.deleteNews(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<NewsItem> searchNewsByTitle(@RequestParam String title) {
        return newsService.searchNewsByTitle(title);
    }

    @GetMapping("/category/{category}")
    public List<NewsItem> getNewsByCategory(@PathVariable String category) {
        return newsService.getNewsByCategory(category);
    }
}