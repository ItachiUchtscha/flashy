package com.patric.flashcard_app.flashcard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashcardRepo extends JpaRepository<Flashcard, Long> {
    public List<Flashcard> findByDeckId(Long id);
}
