package com.br.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.board.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    
}
