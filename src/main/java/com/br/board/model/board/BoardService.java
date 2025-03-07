package com.br.board.model.board;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public Board create (Board board){
        board.setCreationDate(LocalDate.now());
        return boardRepository.save(board);
    }

    @Transactional
    public Board findById(Long id){
        return boardRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Board not found with ID: " + id));
    }

    @Transactional
    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    @Transactional
    public void update(Long id, Board newBoard){
        Board board = boardRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Board not found with ID: " + id));

        board.setName(newBoard.getName());
        board.setLastModifiedDate(LocalDate.now());
        boardRepository.save(board);
    }

    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Board not found with ID: " + id));
        boardRepository.delete(board);
    }

}
