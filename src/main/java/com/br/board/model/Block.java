package com.br.board.model;

import com.br.board.util.entity.AuditableEntity;

import jakarta.persistence.Entity;
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

    private String blockCause;
    private String unBlockCause;

}
