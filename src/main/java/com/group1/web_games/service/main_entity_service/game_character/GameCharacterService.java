package com.group1.web_games.service.main_entity_service.game_character;

import com.group1.web_games.model.intermediate.CharacterItem;
import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.model.main_entity.Skill;
import com.group1.web_games.repo.intermediate_repo.ICharacterItemRepo;
import com.group1.web_games.repo.main_entity_repo.IGameCharacterRepo;
import com.group1.web_games.repo.main_entity_repo.ISkillRepo;
import com.group1.web_games.repo.not_now.ICharacterEquipmentSlotRepo;
import com.group1.web_games.repo.not_now.IEquipmentSlotRepo;
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
    @Autowired
    private ICharacterItemRepo characterItemRepo;
    @Autowired
    private ISkillRepo skillRepo;

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
        GameCharacter gameCharacter1 = new GameCharacter("Công Nghiện", 1, 0, "playable", 5, 5, 5, 5, 1, 1, "thêm sau", true, false);
        GameCharacter gameCharacter2 = new GameCharacter("Tuấn Rau Sạch", 1, 0, "playable", 5, 5, 5, 5, 1, 1, "thêm sau", true, false);
        GameCharacter gameCharacter3 = new GameCharacter("Hải Quý Bưởi", 1, 0, "playable", 5, 5, 5, 5, 1, 1, "thêm sau", true, false);
        GameCharacter gameCharacter4 = new GameCharacter("Hùng Barber", 1, 0, "playable", 5, 5, 5, 5, 1, 1, "thêm sau", true, false);
        characterList.add(gameCharacter1);
        characterList.add(gameCharacter2);
        characterList.add(gameCharacter3);
        characterList.add(gameCharacter4);
        gameCharacterRepo.saveAll(characterList);
//        List<CharacterEquipmentSlot> characterEquipmentSlotList = new ArrayList<>();
//        for (GameCharacter gameCharacter : characterList) {
//            characterEquipmentSlotList.add(new CharacterEquipmentSlot(equipmentSlotRepo.findById(1L).orElse(null), gameCharacter));
//            characterEquipmentSlotList.add(new CharacterEquipmentSlot(equipmentSlotRepo.findById(2L).orElse(null), gameCharacter));
//            characterEquipmentSlotList.add(new CharacterEquipmentSlot(equipmentSlotRepo.findById(3L).orElse(null), gameCharacter));
//        }
//        characterEquipmentSlotRepo.saveAll(characterEquipmentSlotList);
        List<CharacterItem> characterItemList = new ArrayList<>();
        for (var i = 0; i < characterList.size(); i++) {
            for (var j = 0; j < 2; j++) {
                characterItemList.add(new CharacterItem(characterList.get(i)));
            }
        }
        characterItemRepo.saveAll(characterItemList);

        List<Skill> skillList = new ArrayList<>();
        for (var i = 0; i < characterList.size(); i++) {
            skillList.add(new Skill("Đánh thường", "PHYS", "none", 0, 1, "../img/skill/skill-1.webp", characterList.get(i)));
            skillList.add(new Skill("Nộ long cước", "PHYS", "none", 5, 1, "../img/skill/skill-2.webp", characterList.get(i)));
            skillList.add(new Skill("Khóa ánh sáng", "MAGIC", "none", 5, 1, "../img/skill/skill-3.webp", characterList.get(i)));
            skillList.add(new Skill("Cầu vồng tối thượng", "MAGIC", "none", 5, 1, "../img/skill/skill-4.webp", characterList.get(i)));
            skillList.add(new Skill("Khiên đen", "BUFF", "none", 5, 1, "../img/skill/skill-5.webp", characterList.get(i)));
            skillList.add(new Skill("Hồi máu đến chết", "BUFF", "none", 5, 1, "../img/skill/skill-6.webp", characterList.get(i)));
        }
        skillRepo.saveAll(skillList);

        return characterList;
    }

    @Override
    public List<GameCharacter> createEnemies() {
        List<GameCharacter> enemyList = new ArrayList<>();
        GameCharacter enemy1 = new GameCharacter("Huế", 4, 0, "enemy", 5, 10, 10, 10, 0, 0, "thêm sau", true, true);
        GameCharacter enemy2 = new GameCharacter("Diệp", 6, 0, "enemy", 20, 10, 10, 10, 0, 0, "thêm sau", true, true);
        GameCharacter enemy3 = new GameCharacter("Ngũ", 8, 0, "enemy", 10, 20, 5, 15, 0, 0, "thêm sau", true, true);
        GameCharacter enemy4 = new GameCharacter("Duyên Âm", 10, 0, "enemy", 15, 15, 15, 15, 15, 15, "thêm sau", true, true);
        enemyList.add(enemy1);
        enemyList.add(enemy2);
        enemyList.add(enemy3);
        enemyList.add(enemy4);
        gameCharacterRepo.saveAll(enemyList);

        List<Skill> skillList = new ArrayList<>();
        for (var i = 0; i < enemyList.size(); i++) {
            skillList.add(new Skill("Nụ hôn tử thần", "MAGIC", "none", 0, 1, "none", enemyList.get(i)));
            skillList.add(new Skill("Tát lệch mặt", "PHYS", "none", 0, 1, "none", enemyList.get(i)));
        }
        skillRepo.saveAll(skillList);

        return enemyList;
    }

    @Override
    public void deleteCharacterEquipmentSlotRelatedToThisCharacter(Long id) {
        gameCharacterRepo.deleteCharacterEquipmentSlotByCharacterId(id);
    }

//    @Override
//    public List<GameCharacter> showPartyBySession(Long gameSessionId) {
//       return gameCharacterRepo.showPartyBySession(gameSessionId);
//    }


    @Override
    public List<GameCharacter> findListAlivePlayerBySessionId(Long gameSessionId) {
        return gameCharacterRepo.findAliveGameCharacterBySessionId(gameSessionId);
    }

    @Override
    public List<GameCharacter> findListDeadPlayerBySessionId(Long gameSessionId) {
        return gameCharacterRepo.findDeadGameCharacterBySessionId(gameSessionId);
    }

    @Override
    public List<GameCharacter> findListAliveEnemyBySessionId(Long gameSessionId) {
        return gameCharacterRepo.findAliveEnemyBySessionId(gameSessionId);
    }

    @Override
    public List<GameCharacter> findListDeadEnemyBySessionId(Long gameSessionId) {
        return gameCharacterRepo.findDeadEnemyBySessionId(gameSessionId);
    }
}
