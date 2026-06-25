package com.placement.portal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "forum_threads")
@Data
@NoArgsConstructor
public class ForumThread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int replies = 0;
    private String tag;
}
