package com.group1.web_games.service.intermediate_service.inventory;

import com.group1.web_games.model.intermediate.Inventory;
import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.repo.intermediate_repo.IInventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService implements IInventoryService {
    @Autowired
    private IInventoryRepo iInventoryRepo;

    @Override
    public Iterable<Inventory> findAll() {
        return iInventoryRepo.findAll();
    }

    @Override
    public Optional<Inventory> findById(Long id) {
        return iInventoryRepo.findById(id);
    }

    @Override
    public Inventory save(Inventory inventory) {
        return iInventoryRepo.save(inventory);
    }

    @Override
    public void remove(Long id) {
        iInventoryRepo.deleteById(id);

    }

    @Override
    public List<Inventory> init20Inventory(GameSession gameSession) {
        List<Inventory> inventoryList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            inventoryList.add(new Inventory(gameSession));
        }
        return inventoryList;
    }


}
