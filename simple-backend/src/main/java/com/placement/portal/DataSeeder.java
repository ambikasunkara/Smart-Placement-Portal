package com.placement.portal;

import com.placement.portal.model.ForumThread;
import com.placement.portal.model.MockTest;
import com.placement.portal.repository.ForumThreadRepository;
import com.placement.portal.repository.MockTestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final MockTestRepository mockTestRepository;
    private final ForumThreadRepository forumThreadRepository;

    public DataSeeder(MockTestRepository mockTestRepository, ForumThreadRepository forumThreadRepository) {
        this.mockTestRepository = mockTestRepository;
        this.forumThreadRepository = forumThreadRepository;
    }

    @Override
    public void run(String... args) {
        if (mockTestRepository.count() == 0) {
            addMockTest("TCS Mock Test", "TCS", 60, 30, "Medium", "Simulates TCS NQT pattern with aptitude, reasoning, verbal and coding.");
            addMockTest("Infosys Mock Test", "Infosys", 75, 35, "Medium", "Covers Infosys InfyTQ style questions including pseudocode.");
            addMockTest("Wipro Mock Test", "Wipro", 60, 40, "Easy", "Covers Wipro NLTH aptitude, verbal and coding patterns.");
            addMockTest("Amazon Mock Test", "Amazon", 90, 45, "Hard", "SDE-1 level coding problems, OOP design and behavioral questions.");
        }

        if (forumThreadRepository.count() == 0) {
            addThread("How to approach Dynamic Programming problems for beginners?", "Ravi Kumar", 12, "DSA");
            addThread("TCS NQT 2026 - Pattern and difficulty discussion", "Megha Singh", 25, "Mock Tests");
            addThread("Best resources for DBMS normalization?", "Arjun Rao", 8, "Core CS");
            addThread("Tips for HR round - tell me about yourself", "Pooja Nair", 19, "HR Prep");
        }
    }

    private void addMockTest(String name, String company, int duration, int questions, String difficulty, String description) {
        MockTest test = new MockTest();
        test.setName(name);
        test.setCompany(company);
        test.setDuration(duration);
        test.setTotalQuestions(questions);
        test.setDifficulty(difficulty);
        test.setDescription(description);
        mockTestRepository.save(test);
    }

    private void addThread(String title, String author, int replies, String tag) {
        ForumThread thread = new ForumThread();
        thread.setTitle(title);
        thread.setAuthor(author);
        thread.setReplies(replies);
        thread.setTag(tag);
        forumThreadRepository.save(thread);
    }
}
