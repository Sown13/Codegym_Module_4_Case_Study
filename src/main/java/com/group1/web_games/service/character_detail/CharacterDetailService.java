package com.group1.web_games.service.character_detail;

import com.group1.web_games.model.main_entity.CharacterDetail;
import com.group1.web_games.repo.main_entity_repo.ICharacterDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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
}
