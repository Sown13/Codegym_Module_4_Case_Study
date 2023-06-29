package com.group1.web_games.service.main_entity_service.game_session;

import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IGameSessionService extends IGeneralService<GameSession> {
//    Optional<GameSession> findAllByUserId(Long id);

    List<GameSession> findByUserEntityUserId(Long id);

}
