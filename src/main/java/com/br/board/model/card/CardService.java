package com.br.board.model.card;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public Card create (Card card){
        card.setCreationDate(LocalDate.now());
        return cardRepository.save(card);
    }

    @Transactional
    public Card findById(Long id){
        return cardRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Card not found with ID: " + id));
    }

    @Transactional 
    public List<Card> findAll(){
        return cardRepository.findAll();
    } 

    @Transactional
    public void update(Long id, Card newCard){
        Card card = cardRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Card not found with ID: " + id));

        card.setTitle(newCard.getTitle());
        card.setDescription(newCard.getDescription());
        card.setLastModifiedDate(LocalDate.now());
        cardRepository.save(card);
    }

    @Transactional
    public void delete(Long id){
        Card card = cardRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Card not found with ID: " + id));
        cardRepository.delete(card);
    }
}
