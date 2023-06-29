package com.group1.web_games.service.intermediate_service.character_item;

import com.group1.web_games.model.intermediate.CharacterItem;
import com.group1.web_games.model.main_entity.GameItem;
import com.group1.web_games.service.IGeneralService;

import java.util.List;

public interface ICharacterItemService extends IGeneralService<CharacterItem> {
    List<CharacterItem> findCharacterItemByGameCharacterId(Long gameCharacterId);
}
