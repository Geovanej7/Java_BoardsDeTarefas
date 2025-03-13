package com.br.board.controller.DTOs;

import com.br.board.model.columns.Columns;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColumnsRequest {

    private String name;

    public Columns build(){
        return Columns.builder()
        .name(name)
        .build();

    }
}
