package com.group1.web_games.service.skill;

import com.group1.web_games.model.main_entity.Skill;
import com.group1.web_games.repo.main_entity_repo.ISkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillService  implements ISkillService{
    @Autowired
    private ISkillRepo skillRepo;

    @Override
    public Iterable<Skill> findAll() {
        return skillRepo.findAll();
    }

    @Override
    public Optional<Skill> findById(Long id) {
        return skillRepo.findById(id);
    }

    @Override
    public Skill save(Skill skill) {
        return skillRepo.save(skill);
    }

    @Override
    public void remove(Long id) {
     skillRepo.deleteById(id);
    }
}
