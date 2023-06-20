package com.group1.web_games.service.character_skill;

import com.group1.web_games.model.intermediate.CharacterSkill;
import com.group1.web_games.repo.intermediate_repo.ICharacterSkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterSkillService implements ICharacterSkillService {
    @Autowired
    private ICharacterSkillRepo characterSkillRepo;

    @Override
    public Iterable<CharacterSkill> findAll() {
        return characterSkillRepo.findAll();
    }

    @Override
    public Optional<CharacterSkill> findById(Long id) {
        return characterSkillRepo.findById(id);
    }

    @Override
    public CharacterSkill save(CharacterSkill characterSkill) {
        return characterSkillRepo.save(characterSkill);
    }

    @Override
    public void remove(Long id) {
     characterSkillRepo.deleteById(id);
    }
}
