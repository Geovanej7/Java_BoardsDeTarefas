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

import com.br.board.controller.DTOs.BlockRequest;
import com.br.board.model.block.Block;
import com.br.board.model.block.BlockService;

@RestController
@RequestMapping("/controller/block")
@CrossOrigin
public class BlockController {
    @Autowired
    private BlockService blockService;

    @PostMapping 
    public ResponseEntity<Block> create (@RequestBody BlockRequest request){
        Block block = blockService.create(request.build());
        return new ResponseEntity<Block>(block,HttpStatus.CREATED);
    }    

    @GetMapping
    public List<Block> findAll(){
        return blockService.findAll();
    }

    @GetMapping("/{id}")
    public Block findById(@PathVariable Long id){
        return blockService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id")Long id, @RequestBody BlockRequest request){
        blockService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        blockService.delete(id);
        return ResponseEntity.ok().build();
    }

}
