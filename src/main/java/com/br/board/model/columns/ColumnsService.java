package com.br.board.model.columns;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.board.model.board.Board;
import com.br.board.model.board.BoardRepository;

import jakarta.transaction.Transactional;

@Service
public class ColumnsService {

    @Autowired
    private ColumnsRepository columnsRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public Columns create (Long boardId,Columns columns){

        Board board = boardRepository.findById(boardId).get();
        List<Columns> columnsList = board.getColumns();

        columns.setBoard(board);
        columns.setCreationDate(LocalDate.now());
        columnsRepository.save(columns);

        if(columnsList == null){ 
            columnsList = new ArrayList<Columns>();
        }

        columnsList.add(columns);
        board.setColumns(columnsList);
        boardRepository.save(board);
        return columns;

    }

    @Transactional
    public Columns findById(Long id){
        return columnsRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Column not found with ID: " + id));
    }

    @Transactional 
    public List<Columns> findAll(){
        return columnsRepository.findAll();
    } 

    @Transactional
    public void update (long id, Columns newColumns){
        Columns columns = columnsRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Column not found with ID: " + id));

        columns.setName(newColumns.getName());
        columns.setLastModifiedDate(LocalDate.now());
        columnsRepository.save(columns);
    }

    @Transactional
    public void delete(Long id){ 
        Columns columns = columnsRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Column not found with ID: " + id));
        columnsRepository.delete(columns);

        Board board = boardRepository.findById(columns.getBoard().getId())
        .orElseThrow(() -> new RuntimeException("board not found : "));
        board.getColumns().remove(columns);
        boardRepository.save(board);
    }

}
