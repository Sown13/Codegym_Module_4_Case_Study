package com.group1.web_games.service.intermediate_service.inventory;

import com.group1.web_games.model.intermediate.Inventory;
import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.service.IGeneralService;

import java.util.List;

public interface IInventoryService extends IGeneralService<Inventory>{
    public List<Inventory> init20Inventory(GameSession gameSession);
}
