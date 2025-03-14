package com.br.board.model.block;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.board.model.card.Card;
import com.br.board.model.card.CardRepository;

import jakarta.transaction.Transactional;

@Service
public class BlockService {

    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public Block create( Long cardId,Block block) {

        Card card = cardRepository.findById(cardId).get();
        List<Block> blockList = card.getBlocks();

        block.setCard(card);
        block.setCreationDate(LocalDate.now());
        blockRepository.save(block);

        if (blockList == null) {
            blockList = new ArrayList<Block>();
        }

        blockList.add(block);
        card.setBlocks(blockList);
        cardRepository.save(card);
        return block;

    }

    @Transactional
    public Block findById(Long id){
        return blockRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Block not found with ID: " + id));
    }

    @Transactional
    public List<Block> findAll(){
        return blockRepository.findAll();
    }

    @Transactional
    public void update (Long id, Block newBlock){
        Block block = blockRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Block not found with ID: " + id));

        block.setBlockCause(newBlock.getBlockCause());
        block.setUnBlockCause(newBlock.getUnBlockCause());
        block.setLastModifiedDate(LocalDate.now());
        blockRepository.save(block);
    }

    @Transactional
    public void delete (Long id){
        Block block = blockRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Block not found with ID: " + id));
        blockRepository.delete(block);

        Card card = cardRepository.findById(block.getCard().getId())
        .orElseThrow(() -> new RuntimeException("block not found : "));
        card.getBlocks().remove(block);
        cardRepository.save(card);
    }

}
