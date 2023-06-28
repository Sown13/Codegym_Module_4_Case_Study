package com.group1.web_games.service.intermediate_service.character_item;

import com.group1.web_games.model.intermediate.CharacterItem;
import com.group1.web_games.model.main_entity.GameItem;
import com.group1.web_games.repo.intermediate_repo.ICharacterItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterItemService  implements ICharacterItemService{
    @Autowired
    private ICharacterItemRepo characterItemRepo;

    @Override
    public Iterable<CharacterItem> findAll() {
        return characterItemRepo.findAll();
    }

    @Override
    public Optional<CharacterItem> findById(Long id) {
        return characterItemRepo.findById(id);
    }

    @Override
    public CharacterItem save(CharacterItem characterItem) {
        return characterItemRepo.save(characterItem);
    }

    @Override
    public void remove(Long id) {
   characterItemRepo.deleteById(id);
    }


}
