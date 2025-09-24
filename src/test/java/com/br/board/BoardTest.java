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
        board.setName("estudos");

         assertEquals("estudos", board.getName());
    }
    @Test
    void shouldAddColumnToBoard(){
        Board board = new Board();
        board.setName("estudos");
        board.setColumns(new ArrayList<>());

        Columns column = new Columns();
        column.setName("segunda-feira");
        column.setBoard(board);

        board.getColumns().add(column);

        assertEquals(1, board.getColumns().size());
    }

    @Test
    void shouldAddMultipleColumnsToBoard(){
        Board board = new Board();
        board.setName("estudos");
        board.setColumns(new ArrayList<>());

        Columns column1 = new Columns();
        column1.setName("segunda-feira");
        column1.setBoard(board);

        Columns column2 = new Columns();
        column2.setName("terça-feira");
        column2.setBoard(board);

        Columns column3 = new Columns();
        column3.setName("quarta-feira");
        column3.setBoard(board);

        Columns column4 = new Columns();
        column4.setName("quinta-feira");
        column4.setBoard(board);

        Columns column5 = new Columns();
        column5.setName("sexta-feira");
        column5.setBoard(board);

        board.getColumns().add(column1);
        board.getColumns().add(column2);
        board.getColumns().add(column3);
        board.getColumns().add(column4);
        board.getColumns().add(column5);

        assertEquals(5, board.getColumns().size());
    }
}
