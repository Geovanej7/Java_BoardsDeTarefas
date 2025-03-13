package com.br.board.model.columns;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ColumnsService {

    @Autowired
    private ColumnsRepository columnsRepository;

    @Transactional
    public Columns create (Columns columns){
        columns.setCreationDate(LocalDate.now());
        return columnsRepository.save(columns);
    }

    @Transactional
    public Columns findById(Long id){
        return columnsRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Column not found with ID: " + id));
    }

    @Transactional 
    public List<Columns> findAll(){
        return columnsRepository.findAll();
    } 

    @Transactional
    public void update (long id, Columns newColumns){
        Columns columns = columnsRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Column not found with ID: " + id));

        columns.setName(newColumns.getName());
        columns.setLastModifiedDate(LocalDate.now());
        columnsRepository.save(columns);
    }

    @Transactional
    public void delete(Long id){ 
        Columns columns = columnsRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Column not found with ID: " + id));
        columnsRepository.delete(columns);
    }

}
