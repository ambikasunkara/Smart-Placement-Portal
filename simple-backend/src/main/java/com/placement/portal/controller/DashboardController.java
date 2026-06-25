package com.placement.portal.controller;

import com.placement.portal.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> getDashboard(@PathVariable Long userId) {
        Map<String, Object> data = dashboardService.getDashboard(userId);
        return ResponseEntity.ok(data);
    }
}
