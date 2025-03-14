package com.br.board.model.card;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.board.model.columns.Columns;
import com.br.board.model.columns.ColumnsRepository;

import jakarta.transaction.Transactional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ColumnsRepository columnsRepository;

    @Transactional
    public Card create (Long columnId,Card card){

        Columns columns = columnsRepository.findById(columnId).get();
        List<Card> cardList = columns.getCards();

        card.setColumns(columns);
        card.setCreationDate(LocalDate.now());
        cardRepository.save(card);

        if (cardList == null) {
            cardList = new ArrayList<Card>();
        }

        cardList.add(card);
        columns.setCards(cardList);
        columnsRepository.save(columns);
        return card;
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

        Columns columns = columnsRepository.findById(card.getColumns().getId())
        .orElseThrow(() -> new RuntimeException("column not found : "));
        columns.getCards().remove(card);
        columnsRepository.save(columns);
    }
}
