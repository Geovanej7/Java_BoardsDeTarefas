package com.br.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.board.controller.DTOs.ColumnsRequest;
import com.br.board.model.columns.Columns;
import com.br.board.model.columns.ColumnsService;

@RestController
@RequestMapping("/api/columns")
@CrossOrigin
public class ColumnsController {
    @Autowired
    private ColumnsService columnsService;

    @PostMapping("/{boardId}")
    public ResponseEntity<Columns> create(@PathVariable("boardId")Long boardId,@RequestBody ColumnsRequest request){ 
        Columns columns = columnsService.create(boardId,request.build());
        return new ResponseEntity<Columns>(columns,HttpStatus.CREATED);
    }

    @GetMapping
    public List<Columns> findAll(){
        return columnsService.findAll();
    }

    @GetMapping("/{id}")
    public Columns findById(@PathVariable Long id){
        return columnsService.findById(id);
    }

     @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id")Long id, @RequestBody ColumnsRequest request){
        columnsService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        columnsService.delete(id);
        return ResponseEntity.ok().build();
    }
}


