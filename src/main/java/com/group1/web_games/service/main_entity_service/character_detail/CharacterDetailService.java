package com.group1.web_games.service.main_entity_service.character_detail;

import com.group1.web_games.model.main_entity.CharacterDetail;
import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.repo.main_entity_repo.ICharacterDetailRepo;
import com.group1.web_games.repo.main_entity_repo.IGameCharacterRepo;
import com.group1.web_games.service.main_entity_service.game_character.IGameCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CharacterDetailService implements ICharacterDetailService {
    @Autowired
    private ICharacterDetailRepo characterDetailRepo;
    @Autowired
    private IGameCharacterRepo gameCharacterRepo;

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

    @Override
    public CharacterDetail findCharacterDetailByGameCharacterId(Long id) {
        GameCharacter gameCharacter = gameCharacterRepo.findById(id).orElse(null);
        return characterDetailRepo.findCharacterDetailByGameCharacter(gameCharacter);
    }
}
