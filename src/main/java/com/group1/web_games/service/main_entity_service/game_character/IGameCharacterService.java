package com.group1.web_games.service.main_entity_service.game_character;

import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.service.IGeneralService;

import java.util.List;


public interface IGameCharacterService extends IGeneralService<GameCharacter> {
    List<GameCharacter> createPartyOf4();
    List<GameCharacter> createEnemies();
    void deleteCharacterEquipmentSlotRelatedToThisCharacter(Long id);

//    List<GameCharacter> showPartyBySession(Long gameSessionId);

}
