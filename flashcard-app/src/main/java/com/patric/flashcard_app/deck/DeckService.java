package com.patric.flashcard_app.deck;

import com.patric.flashcard_app.user.User;
import com.patric.flashcard_app.user.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {

    private final DeckRepo deckrepo;
    private final DeckMapper deckMapper;
    private final UserRepo userRepo;

    public DeckService(DeckRepo deckrepo, DeckMapper deckMapper, UserRepo userRepo) {
        this.deckrepo = deckrepo;
        this.deckMapper = deckMapper;
        this.userRepo = userRepo;
    }

    public List<DeckDTO> findByUserId(Long userId) {
        return this.deckrepo.findByUserId(userId).stream().map(deckMapper::toDto).toList();
    }

    public DeckDTO findByDeckId(Long deckId) {
        Deck deck = this.deckrepo.findById(deckId).orElseThrow(() -> new DeckNotFoundException("Deck not found: " + deckId));

        return deckMapper.toDto(deck);
    }

    public void deleteDeck(Long id) {
            if (!deckrepo.existsById(id)) {
                throw new DeckNotFoundException("Deck not found: " + id);
            }
            deckrepo.deleteById(id);
    }

    public DeckDTO createDeck(Long userId, DeckDTO dto) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found: " + userId));

        Deck deck = deckMapper.toEntity(dto);
        deck.setUser(user);
        deck = deckrepo.save(deck);

        return deckMapper.toDto(deck);
    }

    public DeckDTO updateDeck(Long deckId, DeckDTO dto) {
        Deck deck = deckrepo.findById(deckId).orElseThrow(() -> new DeckNotFoundException("Deck not found" + deckId));

        deck.setName(dto.getName());
        deck = deckrepo.save(deck);
        return deckMapper.toDto(deck);
    }
}
