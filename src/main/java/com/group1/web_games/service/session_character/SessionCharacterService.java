package com.group1.web_games.service.session_character;

import com.group1.web_games.model.intermediate.SessionCharacter;
import com.group1.web_games.repo.intermediate_repo.ISessionCharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
