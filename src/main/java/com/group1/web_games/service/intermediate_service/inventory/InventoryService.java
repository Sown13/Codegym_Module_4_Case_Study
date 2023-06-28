package com.group1.web_games.service.intermediate_service.inventory;

import com.group1.web_games.model.intermediate.Inventory;
import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.repo.intermediate_repo.IInventoryRepo;
import com.group1.web_games.repo.main_entity_repo.IGameSessionRepo;
import com.group1.web_games.service.main_entity_service.game_session.IGameSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService implements IInventoryService {
    @Autowired
    private IInventoryRepo inventoryRepo;
    @Autowired
    private IGameSessionRepo gameSessionRepo;

    @Override
    public Iterable<Inventory> findAll() {
        return inventoryRepo.findAll();
    }

    @Override
    public Optional<Inventory> findById(Long id) {
        return inventoryRepo.findById(id);
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepo.save(inventory);
    }

    @Override
    public void remove(Long id) {
        inventoryRepo.deleteById(id);

    }

    @Override
    public List<Inventory> init20Inventory(GameSession gameSession) {
        List<Inventory> inventoryList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            inventoryList.add(new Inventory(gameSession));
        }
        inventoryRepo.saveAll(inventoryList);
        return inventoryList;
    }

    @Override
    public List<Inventory> findInventoryByGameSessionId(Long gameSessionId) {
        GameSession gameSession = gameSessionRepo.findById(gameSessionId).orElse(null);
        return inventoryRepo.findInventoryByGameSession(gameSession);
    }
}
