package com.br.board;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.br.board.model.card.Card;
import com.br.board.model.columns.Columns;
import com.br.board.model.columns.ColumnsRepository;

@DataJpaTest
public class ColumnTest {

    @Autowired
    private ColumnsRepository repository;

    @Test
    void shouldSetName(){
        Columns column = new Columns();
        column.setName("to do");

         assertEquals("to do", column.getName());
    }

    @Test
    void shouldNotSaveNullName() {
        Columns column = new Columns();
        column.setName(null);

        assertThrows(Exception.class, () -> {
            repository.saveAndFlush(column); 
        });
    }

    @Test
    void shouldAddCardsToColumn(){
        Columns column = new Columns();
        column.setName("to do");
        column.setCards(new ArrayList<>());

        Card card = new Card();
        card.setTitle("to study");
        card.setDescription("from nine to eleven in the morning");
        card.setColumns(column);

        column.getCards().add(card);

        assertEquals(1, column.getCards().size());
    }
}
