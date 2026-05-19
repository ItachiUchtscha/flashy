package com.patric.flashcard_app.deck;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {

    private final DeckRepo deckrepo;
    private final DeckMapper deckMapper;

    public DeckService(DeckRepo deckrepo, DeckMapper deckMapper) {
        this.deckrepo = deckrepo;
        this.deckMapper = deckMapper;
    }

    public List<DeckDTO> findByUserId(Long userId) {
        return this.deckrepo.findByUserId(userId).stream().map(deckMapper::toDto).toList();
    }

    public DeckDTO findByDeckId(Long deckId) {
        Deck deck = this.deckrepo.findById(deckId).orElseThrow(() -> new RuntimeException("Deck not found Get Deck"));

        return deckMapper.toDto(deck);
    }

    public void deleteDeck(Long id) {
        deckrepo.deleteById(id);
    }

    public DeckDTO createDeck(Long userId, DeckDTO dto) {
        Deck deck = deckMapper.toEntity(dto);

        deck = deckrepo.save(deck);

        return deckMapper.toDto(deck);
    }
}
