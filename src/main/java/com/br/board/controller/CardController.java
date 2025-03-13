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
import com.br.board.controller.DTOs.CardRequest;
import com.br.board.model.card.Card;
import com.br.board.model.card.CardService;

@RestController
@RequestMapping("/controller/card")
@CrossOrigin
public class CardController {
    
    @Autowired
    private CardService cardService;

    @PostMapping 
    public ResponseEntity<Card> create (@RequestBody CardRequest request){
        Card card = cardService.create(request.build());
        return new ResponseEntity<Card>(card,HttpStatus.CREATED);
    }    

    @GetMapping
    public List<Card> findAll(){
        return cardService.findAll();
    }

    @GetMapping("/{id}")
    public Card findById(@PathVariable Long id){
        return cardService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id")Long id, @RequestBody CardRequest request){
        cardService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cardService.delete(id);
        return ResponseEntity.ok().build();
    }
}
