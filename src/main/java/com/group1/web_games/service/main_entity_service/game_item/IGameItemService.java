package com.group1.web_games.service.main_entity_service.game_item;

import com.group1.web_games.model.main_entity.GameItem;
import com.group1.web_games.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IGameItemService extends IGeneralService<GameItem> {
    List<GameItem> getItemListByGameSession(Long gameSessionId);
}
