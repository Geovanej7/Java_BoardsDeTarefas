package com.br.board.model.columns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnsRepository extends JpaRepository<Columns, Long> {

}
