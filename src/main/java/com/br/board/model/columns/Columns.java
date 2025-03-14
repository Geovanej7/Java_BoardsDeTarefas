package com.br.board.model.columns;

import com.br.board.model.board.Board;
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
public class Columns extends AuditableEntity {
    
    @ManyToOne
    @JsonIgnore
    private Board board;

    @Column(nullable = false)
    private String name; 
}
