package com.placement.portal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/interview")
@CrossOrigin(origins = "http://localhost:5173")
public class InterviewController {

    @GetMapping("/hr-questions")
    public ResponseEntity<List<Map<String, Object>>> getHrQuestions() {
        List<Map<String, Object>> questions = List.of(
                Map.of("id", 1, "question", "Tell me about yourself.",
                        "tip", "Keep it under 2 minutes, focus on education, skills, and career goals."),
                Map.of("id", 2, "question", "What are your strengths and weaknesses?",
                        "tip", "Pick a real weakness and show how you are improving on it."),
                Map.of("id", 3, "question", "Why should we hire you?",
                        "tip", "Connect your skills directly to the job requirements."),
                Map.of("id", 4, "question", "Where do you see yourself in 5 years?",
                        "tip", "Show ambition aligned with the company growth path."),
                Map.of("id", 5, "question", "Describe a challenge you faced and how you overcame it.",
                        "tip", "Use the STAR method: Situation, Task, Action, Result.")
        );
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/hiring-rounds")
    public ResponseEntity<List<Map<String, Object>>> getHiringRounds() {
        List<Map<String, Object>> rounds = List.of(
                Map.of("id", 1, "name", "Aptitude Round", "icon", "📊", "description", "Quantitative, logical and verbal ability test.", "duration", "45 mins"),
                Map.of("id", 2, "name", "Coding Round", "icon", "💻", "description", "Solve 2-3 DSA problems within the time limit.", "duration", "60 mins"),
                Map.of("id", 3, "name", "Technical Round", "icon", "🛠️", "description", "In-depth discussion on CS fundamentals and projects.", "duration", "30 mins"),
                Map.of("id", 4, "name", "HR Round", "icon", "🤝", "description", "Behavioral and culture-fit questions.", "duration", "20 mins")
        );
        return ResponseEntity.ok(rounds);
    }
}
