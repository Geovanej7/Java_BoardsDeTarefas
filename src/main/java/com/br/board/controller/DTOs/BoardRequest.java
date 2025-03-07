package com.br.board.controller.DTOs;

import com.br.board.model.board.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    private String name;

    public Board build(){
        return Board.builder()
        .name(name)
        .build();
    }
}

