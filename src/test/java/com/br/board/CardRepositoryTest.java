package com.br.board;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.br.board.model.card.Card;

public class CardRepositoryTest {
    
    @Test
    void shoudCreateCard(){
        Card card = new Card();
        card.setTitle("study");
        card.setDescription("this morning");

        assertEquals("study", card.getTitle());
        assertEquals("this morning", card.getDescription());
    }

   
}
