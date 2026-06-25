package com.placement.portal.repository;

import com.placement.portal.model.ForumThread;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumThreadRepository extends JpaRepository<ForumThread, Long> {
}
