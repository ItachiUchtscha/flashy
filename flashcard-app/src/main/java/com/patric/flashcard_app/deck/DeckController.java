package com.patric.flashcard_app.deck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/decks")
public class DeckController {
    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeckDTO>> getAllDecksByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(deckService.findByUserId(userId));
    }

    @GetMapping("/{deckId}")
    public ResponseEntity<DeckDTO> getDeck(@PathVariable Long deckId) {
        return ResponseEntity.ok(deckService.findByDeckId(deckId));
    }

    @DeleteMapping("/{deckId}")
    public ResponseEntity<Void> deleteDeck(@PathVariable Long deckId) {
        deckService.deleteDeck(deckId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<DeckDTO> createDeck(@PathVariable Long userId, @RequestBody DeckDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deckService.createDeck(userId, dto));
    }

    @PutMapping("/{deckId}")
    public ResponseEntity<DeckDTO> updateDeck(@PathVariable Long deckId, @RequestBody DeckDTO dto) {
        return ResponseEntity.ok(deckService.updateDeck(deckId, dto));
    }
}
