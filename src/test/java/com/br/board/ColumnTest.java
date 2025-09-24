package com.br.board;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.br.board.model.card.Card;
import com.br.board.model.columns.Columns;

public class ColumnTest {
    @Test
    void shouldSetName(){
        Columns column = new Columns();
        column.setName("segunda-feira");

         assertEquals("segunda-feira", column.getName());
    }

    @Test
    void shouldAddCardsToColumn(){
        Columns column = new Columns();
        column.setName("segunda-feira");
        column.setCards(new ArrayList<>());

        Card card = new Card();
        card.setTitle("estudar");
        card.setDescription("das 9 as 11 da manhã");
        card.setColumns(column);

        column.getCards().add(card);

        assertEquals(1, column.getCards().size());
    }
}
