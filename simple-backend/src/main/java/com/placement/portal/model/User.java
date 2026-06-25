package com.placement.portal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private int xp = 0;
    private int level = 1;
    private int dailyStreak = 0;
    private int placementReadiness = 0;
    private String college = "";
}
