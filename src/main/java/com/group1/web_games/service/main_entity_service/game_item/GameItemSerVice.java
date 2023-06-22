package com.group1.web_games.service.main_entity_service.game_item;

import com.group1.web_games.model.main_entity.GameItem;
import com.group1.web_games.repo.main_entity_repo.IGameItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameItemSerVice implements IGameItemService {
    @Autowired
    private IGameItemRepo gameItemRepo;

    @Override
    public Iterable<GameItem> findAll() {
        return gameItemRepo.findAll();
    }

    @Override
    public Optional<GameItem> findById(Long id) {
        return gameItemRepo.findById(id);
    }

    @Override
    public GameItem save(GameItem gameItem) {
        return gameItemRepo.save(gameItem);
    }

    @Override
    public void remove(Long id) {
        gameItemRepo.deleteById(id);
    }

}
