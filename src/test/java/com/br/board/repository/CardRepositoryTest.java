package com.br.board.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.br.board.model.card.Card;
import com.br.board.model.card.CardRepository;

@DataJpaTest
public class CardRepositoryTest {
    
    @Autowired
    private CardRepository cardRepository;

    @Test
    void shoudCreateCard(){
        Card card = Card.builder()
                    .title("study")
                    .description("this morning")
                    .build();

        Card saved = cardRepository.saveAndFlush(card);
        assertEquals("study", saved.getTitle());
        assertEquals("this morning", saved.getDescription());
    }

    @Test 
    void shouldNotSaveCardWithoutTitle(){
        Card card = Card.builder()
                    .title(null)
                    .description("This morning")
                    .build();
    
        assertThrows(Exception.class, ()->{
            cardRepository.saveAndFlush(card);
        });
    }

    @Test 
    void shouldNotSaveCardWithoutDescription(){
        Card card = Card.builder()
                    .title("study")
                    .description(null)
                    .build();
    
        assertThrows(Exception.class, ()->{
            cardRepository.saveAndFlush(card);
        });
    }

   
}
