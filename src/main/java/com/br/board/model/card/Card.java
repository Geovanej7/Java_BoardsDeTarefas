package com.br.board.model.card;

import com.br.board.model.columns.Columns;
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
public class Card extends AuditableEntity {

    @ManyToOne
    @JsonIgnore
    private Columns columns;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Builder.Default //mantem o valor padrão
    @Column(nullable = false)
    private boolean blocked = false;
    
}
