package com.group1.web_games.service.main_entity_service.character_detail;

import com.group1.web_games.model.main_entity.CharacterDetail;
import com.group1.web_games.repo.main_entity_repo.ICharacterDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CharacterDetailService implements ICharacterDetailService {
    @Autowired
    private ICharacterDetailRepo characterDetailRepo;

    @Override
    public Iterable<CharacterDetail> findAll() {
        return characterDetailRepo.findAll();
    }

    @Override
    public Optional<CharacterDetail> findById(Long id) {
        return characterDetailRepo.findById(id);
    }

    @Override
    public CharacterDetail save(CharacterDetail characterDetail) {
        return characterDetailRepo.save(characterDetail);
    }

    @Override
    public void remove(Long id) {
        characterDetailRepo.deleteById(id);
    }

    @Override
    public List<CharacterDetail> findListAlivePlayerDetailBySessionId(Long gameSessionId) {
        return characterDetailRepo.findAlivePlayerDetailBySessionId(gameSessionId);
    }

    @Override
    public List<CharacterDetail> findListDeadPlayerDetailBySessionId(Long gameSessionId) {
        return characterDetailRepo.findDeadPlayerDetailBySessionId(gameSessionId);
    }

    @Override
    public List<CharacterDetail> findListAliveEnemyDetailBySessionId(Long gameSessionId) {
        return characterDetailRepo.findAliveEnemyDetailBySessionId(gameSessionId);
    }

    @Override
    public List<CharacterDetail> findListDeadEnemyDetailBySessionId(Long gameSessionId) {
        return characterDetailRepo.findDeadEnemyDetailBySessionId(gameSessionId);
    }
}
