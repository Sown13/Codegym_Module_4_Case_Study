package com.group1.web_games.service.intermediate_service.session_character;

import com.group1.web_games.model.intermediate.SessionCharacter;
import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.service.IGeneralService;

import java.util.List;

public interface ISessionCharacterService extends IGeneralService<SessionCharacter> {
    List<SessionCharacter> bindCharacterToSession(GameSession gameSession, List<GameCharacter> characterList);
}
