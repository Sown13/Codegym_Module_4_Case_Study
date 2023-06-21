package com.group1.web_games.service.game_session;

import com.group1.web_games.model.intermediate.SessionCharacter;
import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.repo.intermediate_repo.ISessionCharacterRepo;
import com.group1.web_games.repo.main_entity_repo.IGameSessionRepo;
import com.group1.web_games.service.game_character.IGameCharacterService;
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
    private ISessionCharacterRepo sessionCharacterRepo;
    @Autowired
    private IGameCharacterService gameCharacterService;

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
        List<SessionCharacter> sessionCharacterList = new ArrayList<>();
        List<GameCharacter> characterList = gameCharacterService.createPartyOf4();
        for (GameCharacter gameCharacter : characterList) {
            sessionCharacterList.add(new SessionCharacter(gameSession, gameCharacter));
        }
        sessionCharacterRepo.saveAll(sessionCharacterList);

        return gameSession;
    }

    @Override
    public void remove(Long id) {
        gameSessionRepo.deleteById(id);
    }
}
