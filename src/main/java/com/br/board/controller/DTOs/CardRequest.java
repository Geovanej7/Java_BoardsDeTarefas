package com.br.board.controller.DTOs;

import com.br.board.model.card.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {

    private String title;
    private String description;

    public Card build(){
        return Card.builder()
        .title(title)
        .description(description)
        .build();
    }
}
