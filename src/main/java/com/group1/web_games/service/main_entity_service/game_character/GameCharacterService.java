package com.group1.web_games.service.main_entity_service.game_character;

import com.group1.web_games.model.intermediate.CharacterEquipmentSlot;
import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.repo.intermediate_repo.ICharacterEquipmentSlotRepo;
import com.group1.web_games.repo.main_entity_repo.IEquipmentSlotRepo;
import com.group1.web_games.repo.main_entity_repo.IGameCharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameCharacterService implements IGameCharacterService {
    @Autowired
    private IGameCharacterRepo gameCharacterRepo;
    @Autowired
    private ICharacterEquipmentSlotRepo characterEquipmentSlotRepo;
    @Autowired
    private IEquipmentSlotRepo equipmentSlotRepo;

    @Override
    public Iterable<GameCharacter> findAll() {
        return gameCharacterRepo.findAll();
    }

    @Override
    public Optional<GameCharacter> findById(Long id) {

        return gameCharacterRepo.findById(id);
    }

    @Override
    public GameCharacter save(GameCharacter gameCharacter) {
        return gameCharacterRepo.save(gameCharacter);
    }


    @Override
    public void remove(Long id) {
        gameCharacterRepo.deleteById(id);
    }


    @Override
    public List<GameCharacter> createPartyOf4() {
        List<GameCharacter> characterList = new ArrayList<>();
        GameCharacter gameCharacter1 = new GameCharacter("Dua", 1, 0, "Tom", 5, 5, 10, 10, 10, 10, "Dep trai", true);
        GameCharacter gameCharacter2 = new GameCharacter("Son", 1, 0, "Son", 5, 5, 10, 10, 10, 10, "Dep trai", true);
        GameCharacter gameCharacter3 = new GameCharacter("Tuan", 1, 0, "Tuan", 5, 5, 10, 10, 10, 10, "Dep trai", true);
        GameCharacter gameCharacter4 = new GameCharacter("Cong", 1, 0, "Cong", 5, 5, 10, 10, 10, 10, "Dep trai", true);
        characterList.add(gameCharacter1);
        characterList.add(gameCharacter2);
        characterList.add(gameCharacter3);
        characterList.add(gameCharacter4);
        gameCharacterRepo.saveAll(characterList);
        List<CharacterEquipmentSlot> characterEquipmentSlotList = new ArrayList<>();
        for (GameCharacter gameCharacter : characterList) {
            characterEquipmentSlotList.add(new CharacterEquipmentSlot(equipmentSlotRepo.findById(1L).orElse(null), gameCharacter));
            characterEquipmentSlotList.add(new CharacterEquipmentSlot(equipmentSlotRepo.findById(2L).orElse(null), gameCharacter));
            characterEquipmentSlotList.add(new CharacterEquipmentSlot(equipmentSlotRepo.findById(3L).orElse(null), gameCharacter));
        }
        characterEquipmentSlotRepo.saveAll(characterEquipmentSlotList);
        return characterList;

    }
}
