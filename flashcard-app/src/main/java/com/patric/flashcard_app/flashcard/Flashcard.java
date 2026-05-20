package com.patric.flashcard_app.flashcard;

import com.patric.flashcard_app.deck.Deck;
import jakarta.persistence.*;

@Entity
public class Flashcard {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String front;
    private String back;

    @ManyToOne
    @JoinColumn(name = "deckID")
    private Deck deck;
}
