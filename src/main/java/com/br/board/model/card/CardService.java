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

        Columns columns = columnsRepository.findById(columnId).get(); //busca a coluna no banco
        List<Card> cardList = columns.getCards(); //cria uma instância da lista de cards da coluna

        //se a lista de card não existir ela deve ser criada 
        if (cardList == null) { cardList = new ArrayList<Card>();}

        //seta a referência de coluna dentro do card
        card.setColumns(columns); 
        card.setCreationDate(LocalDate.now()); 
        cardRepository.save(card); 

        //adiciona card na lista e atualizar a lista dentro da coluna 
        cardList.add(card); 
        columns.setCards(cardList);
        columns.setLastModifiedDate(LocalDate.now());
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
    public void moveCard(Long cardId, Long currentColumnId, Long destinationColumnId){ 
        
        Columns currentColumn = columnsRepository.findById(currentColumnId).get(); //busca no banco a coluna atual
        Columns destinationColumn = columnsRepository.findById(destinationColumnId).get();//busca no banco a coluna de destino

        List<Card> currentList = currentColumn.getCards();//cria uma instância da lista de cards da coluna atual 
        List<Card> destinationList = destinationColumn.getCards();//cria uma instância da lista de cards da coluna de destino

        Card card = cardRepository.findById(cardId)
        .orElseThrow(() -> new RuntimeException("Card not found with ID: " + cardId));//busca o card pelo id ou retorna um errro

        destinationList.add(card);//adiciona o card na instância da lista de destino
        destinationColumn.setCards(destinationList);// atualiza a lista na coluna de destino 

        currentList.remove(card);//remove o card da lista de onde ele veio 
        currentColumn.setCards(currentList);// salva a lista na coluna de onde o card veio

        card.setColumns(destinationColumn); //atualiza no card a lista que é responsavel por ele 

        //atualizada a data de modificação dos objetos
        card.setLastModifiedDate(LocalDate.now()); 
        currentColumn.setLastModifiedDate(LocalDate.now()); 
        destinationColumn.setLastModifiedDate(LocalDate.now());
        
        //salvando todos objetos
        cardRepository.save(card);
        columnsRepository.save(currentColumn);
        columnsRepository.save(destinationColumn);

    }

    @Transactional
    public void delete(Long id){

        //busca o card pelo id e deleta
        Card card = cardRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Card not found with ID: " + id));
        cardRepository.delete(card);

        //busca a coluna responsavel pelo card e exclui a referência do card dentro dela
        Columns columns = columnsRepository.findById(card.getColumns().getId())
        .orElseThrow(() -> new RuntimeException("column not found : "));
        columns.getCards().remove(card);
        columns.setLastModifiedDate(LocalDate.now());
        columnsRepository.save(columns);
    }
}
