package com.riseconnect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.Map;

@RestController
@RequestMapping("/api/forms")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class FormController {

    @PostMapping("/contact")
    public ResponseEntity<Map<String, String>> submitContactForm(@RequestBody ContactForm form) {
        // For now, just return success - in a real app, you'd save this to database or send email
        return ResponseEntity.ok(Map.of("message", "Thank you for your interest! We'll be in touch soon."));
    }

    @PostMapping("/newsletter")
    public ResponseEntity<Map<String, String>> subscribeNewsletter(@RequestBody NewsletterForm form) {
        // For now, just return success - in a real app, you'd save this to database
        return ResponseEntity.ok(Map.of("message", "Successfully subscribed to newsletter!"));
    }

    public static class ContactForm {
        @NotBlank(message = "Name is required")
        private String name;
        
        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        private String email;
        
        private String message;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    public static class NewsletterForm {
        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        private String email;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
}
