package com.group1.web_games.service.main_entity_service.character_detail;

import com.group1.web_games.model.main_entity.CharacterDetail;
import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.service.IGeneralService;

import java.util.List;

public interface ICharacterDetailService extends IGeneralService<CharacterDetail> {
    List<CharacterDetail> findListAlivePlayerDetailBySessionId(Long gameSessionId);
    List<CharacterDetail> findListDeadPlayerDetailBySessionId(Long gameSessionId);
    List<CharacterDetail> findListAliveEnemyDetailBySessionId(Long gameSessionId);
    List<CharacterDetail> findListDeadEnemyDetailBySessionId(Long gameSessionId);

    CharacterDetail findCharacterDetailByGameCharacterId(Long id);
}
