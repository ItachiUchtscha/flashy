package com.patric.flashcard_app.deck;

public class DeckMapper {

    public DeckDTO toDto(Deck deck) {
        DeckDTO dto = new DeckDTO();
        dto.setId(deck.getDeckId());
        dto.setName(deck.getName());

        return dto;
    }

    public Deck toEntity(DeckDTO dto) {
        Deck deck = new Deck();
        deck.setName(dto.getName());
        return deck;
    }
}
