package com.placement.portal.controller;

import com.placement.portal.model.MockTest;
import com.placement.portal.repository.MockTestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mock-tests")
@CrossOrigin(origins = "http://localhost:5173")
public class MockTestController {

    private final MockTestRepository mockTestRepository;

    public MockTestController(MockTestRepository mockTestRepository) {
        this.mockTestRepository = mockTestRepository;
    }

    @GetMapping
    public ResponseEntity<List<MockTest>> getAllMockTests() {
        return ResponseEntity.ok(mockTestRepository.findAll());
    }

    @GetMapping("/daily-practice")
    public ResponseEntity<List<Map<String, Object>>> getDailyPractice() {
        List<Map<String, Object>> questions = List.of(
                Map.of("id", 1, "question", "If 20% of a number is 50, what is the number?",
                        "options", List.of("200", "250", "300", "150"), "answer", "250", "difficulty", "Easy", "topic", "Percentages"),
                Map.of("id", 2, "question", "What is the time complexity of binary search?",
                        "options", List.of("O(n)", "O(log n)", "O(n^2)", "O(1)"), "answer", "O(log n)", "difficulty", "Easy", "topic", "Algorithms"),
                Map.of("id", 3, "question", "Which data structure uses LIFO order?",
                        "options", List.of("Queue", "Stack", "Linked List", "Tree"), "answer", "Stack", "difficulty", "Easy", "topic", "Data Structures"),
                Map.of("id", 4, "question", "In DBMS, which normal form removes transitive dependency?",
                        "options", List.of("1NF", "2NF", "3NF", "BCNF"), "answer", "3NF", "difficulty", "Medium", "topic", "DBMS"),
                Map.of("id", 5, "question", "Which protocol operates at the application layer?",
                        "options", List.of("TCP", "IP", "HTTP", "ARP"), "answer", "HTTP", "difficulty", "Medium", "topic", "Computer Networks")
        );
        return ResponseEntity.ok(questions);
    }
}
