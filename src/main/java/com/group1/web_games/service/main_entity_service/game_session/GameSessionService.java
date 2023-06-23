package com.group1.web_games.service.main_entity_service.game_session;

import com.group1.web_games.model.intermediate.Inventory;
import com.group1.web_games.model.intermediate.SessionCharacter;
import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.repo.intermediate_repo.IInventoryRepo;
import com.group1.web_games.repo.intermediate_repo.ISessionCharacterRepo;
import com.group1.web_games.repo.main_entity_repo.IGameSessionRepo;
import com.group1.web_games.service.intermediate_service.inventory.IInventoryService;
import com.group1.web_games.service.intermediate_service.session_character.ISessionCharacterService;
import com.group1.web_games.service.main_entity_service.game_character.IGameCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameSessionService implements IGameSessionService {
    @Autowired
    private IGameSessionRepo gameSessionRepo;
    @Autowired
    private ISessionCharacterService sessionCharacterService;
    @Autowired
    private IGameCharacterService gameCharacterService;
    @Autowired
    private IInventoryService inventoryService;

    @Override
    public Iterable<GameSession> findAll() {
        return gameSessionRepo.findAll();
    }

    @Override
    public Optional<GameSession> findById(Long id) {
        return gameSessionRepo.findById(id);
    }

    @Override
    public GameSession save(GameSession gameSession) {
        gameSessionRepo.save(gameSession);
        List<GameCharacter> characterList = gameCharacterService.createPartyOf4();
        sessionCharacterService.bindCharacterToSession(gameSession, characterList);
        List<GameCharacter> enemyList = gameCharacterService.createEnemies();
        sessionCharacterService.bindCharacterToSession(gameSession, enemyList);
        inventoryService.init20Inventory(gameSession);
        return gameSession;
    }

    @Override
    public void remove(Long id) {
        gameSessionRepo.deleteById(id);
    }

}
