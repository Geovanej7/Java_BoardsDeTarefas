package com.br.board.repository; 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.br.board.model.board.Board;
import com.br.board.model.board.BoardRepository;
import com.br.board.model.columns.Columns;


@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void shouldSaveBoardWithValidName(){

        Board board = Board.builder()
                    .name("studies")
                    .build();

        Board saved = boardRepository.saveAndFlush(board);
        assertNotNull(saved.getId());
        assertEquals("studies", saved.getName());
    }

    @Test
    void shouldNotSaveBoardWithoutName(){
        Board board = Board.builder()
            .name(null)
            .build();
        
        assertThrows(Exception.class, () -> {
            boardRepository.saveAndFlush(board);
        });
    }

    @Test
    void shouldSaveBoardWithColumns() {
        Board board = new Board();
        board.setName("studies");
        board.setColumns(new ArrayList<>());

        Columns column = new Columns();
        column.setName("to do");
        column.setBoard(board);

        board.getColumns().add(column);

        Board saved = boardRepository.saveAndFlush(board);

        assertNotNull(saved.getId());
        assertEquals(1, saved.getColumns().size());
        assertEquals("to do", saved.getColumns().get(0).getName());
    }
    
}
