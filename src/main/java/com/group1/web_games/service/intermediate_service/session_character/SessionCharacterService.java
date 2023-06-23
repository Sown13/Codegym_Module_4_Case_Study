package com.group1.web_games.service.intermediate_service.session_character;

import com.group1.web_games.model.intermediate.SessionCharacter;
import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.repo.intermediate_repo.ISessionCharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessionCharacterService implements ISessionCharacterService {
    @Autowired
    private ISessionCharacterRepo sessionCharacterRepo;

    @Override
    public Iterable<SessionCharacter> findAll() {
        return sessionCharacterRepo.findAll();
    }

    @Override
    public Optional<SessionCharacter> findById(Long id) {
        return sessionCharacterRepo.findById(id);
    }

    @Override
    public SessionCharacter save(SessionCharacter sessionCharacter) {
        return sessionCharacterRepo.save(sessionCharacter);
    }

    @Override
    public void remove(Long id) {
        sessionCharacterRepo.deleteById(id);
    }

    @Override
    public List<SessionCharacter> bindCharacterToSession(GameSession gameSession, List<GameCharacter> characterList) {
        List<SessionCharacter> sessionCharacterList = new ArrayList<>();
        for (GameCharacter gameCharacter : characterList) {
            sessionCharacterList.add(new SessionCharacter(gameSession, gameCharacter));
        }
        sessionCharacterRepo.saveAll(sessionCharacterList);
        return sessionCharacterList;
    }
}
