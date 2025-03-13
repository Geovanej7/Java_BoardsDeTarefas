package com.br.board.controller.DTOs;

import com.br.board.model.block.Block;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlockRequest {
    private String blockCause;
    private String unBlockCause;

    public Block build(){
        return Block.builder()
        .blockCause(blockCause)
        .unBlockCause(unBlockCause)
        .build();
    }
}
