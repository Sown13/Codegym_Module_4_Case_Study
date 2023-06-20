package com.group1.web_games.service.game_session;

import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.repo.main_entity_repo.IGameItemRepo;
import com.group1.web_games.repo.main_entity_repo.IGameSessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameSessionService implements IGameSessionService{
    @Autowired
    private IGameSessionRepo gameSessionRepo;

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
        return gameSessionRepo.save(gameSession);
    }

    @Override
    public void remove(Long id) {
        gameSessionRepo.deleteById(id);
    }
}
