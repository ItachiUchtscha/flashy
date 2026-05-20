package com.patric.flashcard_app.user;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String FirstName;
    private String LastName;

    @Column(unique = true)
    private String email;

    private String password;
}
