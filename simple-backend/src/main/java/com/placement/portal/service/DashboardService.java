package com.placement.portal.service;

import com.placement.portal.model.User;
import com.placement.portal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    private final UserRepository userRepository;

    public DashboardService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, Object> getDashboard(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Map<String, Object> data = new HashMap<>();
        data.put("name", user.getName());
        data.put("email", user.getEmail());
        data.put("xp", user.getXp());
        data.put("level", user.getLevel());
        data.put("dailyStreak", user.getDailyStreak());
        data.put("placementReadiness", user.getPlacementReadiness());
        data.put("college", user.getCollege());

        data.put("skillProgress", List.of(
                Map.of("skill", "Aptitude & Reasoning", "progress", 82),
                Map.of("skill", "Coding & DSA", "progress", 65),
                Map.of("skill", "Core CS Subjects", "progress", 70),
                Map.of("skill", "AI & Emerging Tech", "progress", 45),
                Map.of("skill", "Placement Prep", "progress", 90)
        ));

        data.put("dailyChallenges", List.of(
                Map.of("id", 1, "title", "Solve 5 DSA Problems", "reward", "+50 XP", "completed", true),
                Map.of("id", 2, "title", "Complete Aptitude Quiz (10 Qs)", "reward", "+30 XP", "completed", true),
                Map.of("id", 3, "title", "Attempt 1 Mock Interview Question", "reward", "+40 XP", "completed", false),
                Map.of("id", 4, "title", "Read 1 Core CS Topic", "reward", "+20 XP", "completed", false)
        ));

        data.put("badges", List.of(
                Map.of("id", 1, "name", "DSA Master", "icon", "🏅", "earned", true),
                Map.of("id", 2, "name", "Aptitude Expert", "icon", "🧠", "earned", true),
                Map.of("id", 3, "name", "Interview Ready", "icon", "🎤", "earned", false),
                Map.of("id", 4, "name", "Streak Champion", "icon", "🔥", "earned", false),
                Map.of("id", 5, "name", "Quiz Wizard", "icon", "⚡", "earned", true)
        ));

        return data;
    }
}
