package com.br.board.model.block;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class BlockService {

    @Autowired
    private BlockRepository blockRepository;

    @Transactional
    public Block create(Block block) {
        block.setCreationDate(LocalDate.now());
        return blockRepository.save(block);
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
    }

}
