package com.br.board.model.board;

import java.util.List;

import com.br.board.model.columns.Columns;
import com.br.board.util.entity.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Board extends AuditableEntity{

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy ="board", orphanRemoval = true ,fetch = FetchType.EAGER)
    private List<Columns> columns;
}
