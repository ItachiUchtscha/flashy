package com.patric.flashcard_app.flashcard;

import jakarta.persistence.*;

@Entity
public class Flashcard {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long flashcardId;
    private String front;
    private String back;

    @ManyToOne
    @JoinColumn(name = "deckID")
    private Long deckId;
}
