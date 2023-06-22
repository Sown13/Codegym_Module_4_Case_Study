package com.group1.web_games.service.main_entity_service.game_character;

import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.service.IGeneralService;

import java.util.List;


public interface IGameCharacterService extends IGeneralService<GameCharacter> {
    public List<GameCharacter> createPartyOf4();
    public void deleteCharacterEquipmentSlotRelatedToThisCharacter(Long id);
}
