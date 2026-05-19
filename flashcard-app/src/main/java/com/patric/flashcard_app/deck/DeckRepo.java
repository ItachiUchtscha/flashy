package com.patric.flashcard_app.deck;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeckRepo extends JpaRepository<Deck, Long> {
    List<Deck> findByUserId(Long id);

    Optional<Deck> findById(Long id);

    void deleteById(Long id);
}
