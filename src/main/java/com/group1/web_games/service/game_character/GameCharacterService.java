package com.group1.web_games.service.game_character;

import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.repo.main_entity_repo.IGameCharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GameCharacterService implements IGameCharacterService{
    @Autowired
    private IGameCharacterRepo gameCharacterRepo;
    @Override
    public Iterable<GameCharacter> findAll() {
        return gameCharacterRepo.findAll();
    }

    @Override
    public Optional<GameCharacter> findById(Long id) {

        return gameCharacterRepo.findById(id);
    }

    @Override
    public GameCharacter save(GameCharacter gameCharacter) {

        return gameCharacterRepo.save(gameCharacter);
    }

    @Override
    public void remove(Long id) {
        gameCharacterRepo.deleteById(id);
    }
}
