package com.br.board.model.block;

import com.br.board.model.card.Card;
import com.br.board.util.entity.AuditableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Block extends AuditableEntity{

    @ManyToOne
    @JsonIgnore
    private Card card;

    @Column(nullable = false)
    private String blockCause;
    @Column(nullable = false)
    private String unBlockCause;

}
