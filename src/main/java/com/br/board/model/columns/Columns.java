package com.br.board.model.columns;

import java.util.List;

import com.br.board.model.board.Board;
import com.br.board.model.card.Card;
import com.br.board.util.entity.AuditableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Columns extends AuditableEntity {
    
    @ManyToOne
    @JsonIgnore
    private Board board;

    @Column(nullable = false)
    private String name; 

    @OneToMany(mappedBy = "columns", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Card> cards;
}
