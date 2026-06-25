package com.placement.portal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mock_tests")
@Data
@NoArgsConstructor
public class MockTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String company;
    private int duration;
    private int totalQuestions;
    private String difficulty;
    private String description;
}
