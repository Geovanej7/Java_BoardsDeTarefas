package com.br.board;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.br.board.model.card.Card;
import com.br.board.model.columns.Columns;
import com.br.board.model.columns.ColumnsRepository;

@DataJpaTest
public class ColumnRepositoryTest {

    @Autowired
    private ColumnsRepository columnsRepository;

    @Test
    void shouldSetName(){
        Columns column = Columns.builder()
                        .name("to do")
                        .build();
        
        Columns saved = columnsRepository.saveAndFlush(column);
        assertNotNull(saved.getId());
        assertEquals("to do", saved.getName());
    }

    @Test
    void shouldNotSaveNullName() {
        Columns column = new Columns();
        column.setName(null);

        assertThrows(Exception.class, () -> {
            columnsRepository.saveAndFlush(column); 
        });
    }

    @Test
    void shouldAddCardsToColumn(){
        Columns column = Columns.builder()
                        .name("to do")
                        .build();
        column.setCards(new ArrayList<>());


        Card card = Card.builder()
                        .title("to study")
                        .description("from nine to eleven in the morning")
                        .build();
        card.setColumns(column);

        column.getCards().add(card);

        Columns saved = columnsRepository.saveAndFlush(column);

        assertNotNull(saved.getId());
        assertEquals(1, column.getCards().size());
        assertEquals("to study", saved.getCards().get(0).getTitle());
    }
}
