package com.placement.portal.controller;

import com.placement.portal.model.ForumThread;
import com.placement.portal.repository.ForumThreadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/community")
@CrossOrigin(origins = "http://localhost:5173")
public class CommunityController {

    private final ForumThreadRepository forumThreadRepository;

    public CommunityController(ForumThreadRepository forumThreadRepository) {
        this.forumThreadRepository = forumThreadRepository;
    }

    @GetMapping("/threads")
    public ResponseEntity<List<ForumThread>> getThreads() {
        return ResponseEntity.ok(forumThreadRepository.findAll());
    }

    @PostMapping("/threads")
    public ResponseEntity<ForumThread> createThread(@RequestBody ForumThread thread) {
        ForumThread saved = forumThreadRepository.save(thread);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/mentors")
    public ResponseEntity<List<Map<String, Object>>> getMentors() {
        List<Map<String, Object>> mentors = List.of(
                Map.of("id", 1, "name", "Anjali Desai", "role", "SDE-2 @ Amazon", "expertise", "DSA, System Design", "rating", 4.9),
                Map.of("id", 2, "name", "Rahul Bansal", "role", "Product Manager @ Microsoft", "expertise", "HR, Resume Review", "rating", 4.8),
                Map.of("id", 3, "name", "Sandeep Reddy", "role", "SDE-1 @ Google", "expertise", "Coding Interviews", "rating", 4.7)
        );
        return ResponseEntity.ok(mentors);
    }

    @GetMapping("/study-groups")
    public ResponseEntity<List<Map<String, Object>>> getStudyGroups() {
        List<Map<String, Object>> groups = List.of(
                Map.of("id", 1, "name", "DSA Daily Grind", "members", 142, "focus", "Daily DSA problem solving"),
                Map.of("id", 2, "name", "Aptitude Warriors", "members", 98, "focus", "Quant and reasoning practice"),
                Map.of("id", 3, "name", "Core CS Revision Squad", "members", 76, "focus", "OS, DBMS, CN revision")
        );
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/peer-interviews")
    public ResponseEntity<List<Map<String, Object>>> getPeerInterviewSlots() {
        List<Map<String, Object>> slots = List.of(
                Map.of("id", 1, "peer", "Vikram Singh", "topic", "Coding Round - Arrays & Strings", "time", "Today, 6:00 PM", "status", "Open"),
                Map.of("id", 2, "peer", "Neha Joshi", "topic", "HR Round Practice", "time", "Tomorrow, 5:00 PM", "status", "Open"),
                Map.of("id", 3, "peer", "Sahil Khan", "topic", "System Design Basics", "time", "Tomorrow, 8:00 PM", "status", "Booked")
        );
        return ResponseEntity.ok(slots);
    }
}
