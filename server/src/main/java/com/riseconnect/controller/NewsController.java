package com.riseconnect.controller;

import com.riseconnect.model.NewsItem;
import com.riseconnect.repo.InMemoryStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final InMemoryStore store;

    public NewsController(InMemoryStore store) { this.store = store; }

    @GetMapping
    public List<NewsItem> list() { return store.listNews(); }

    @PostMapping
    public NewsItem create(@RequestBody NewsItem item) { return store.createNews(item); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { return store.deleteNews(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
}


