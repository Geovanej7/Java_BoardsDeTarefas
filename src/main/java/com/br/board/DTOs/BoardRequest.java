package com.br.board.DTOs;

import com.br.board.model.Board;

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

