package com.br.board; 
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.br.board.model.board.Board;
import com.br.board.model.columns.Columns;

public class BoardTest {

    @Test
    void shouldSetName(){
        Board board = new Board();
        board.setName("studies");

         assertEquals("studies", board.getName());
    }
    @Test
    void shouldAddColumnToBoard(){
        Board board = new Board();
        board.setName("studies");
        board.setColumns(new ArrayList<>());

        Columns column = new Columns();
        column.setName("to do");
        column.setBoard(board);

        board.getColumns().add(column);

        assertEquals(1, board.getColumns().size());
    }

    @Test
    void shouldAddMultipleColumnsToBoard(){
        Board board = new Board();
        board.setName("studies");
        board.setColumns(new ArrayList<>());

        Columns column1 = new Columns();
        column1.setName("to do");
        column1.setBoard(board);

        Columns column2 = new Columns();
        column2.setName("doing");
        column2.setBoard(board);

        Columns column3 = new Columns();
        column3.setName("done");
        column3.setBoard(board);

        board.getColumns().add(column1);
        board.getColumns().add(column2);
        board.getColumns().add(column3);

        assertEquals(3, board.getColumns().size());
    }
}
