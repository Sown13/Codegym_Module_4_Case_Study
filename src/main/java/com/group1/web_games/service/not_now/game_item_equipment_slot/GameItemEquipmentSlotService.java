package com.group1.web_games.service.not_now.game_item_equipment_slot;

import com.group1.web_games.model.not_now.GameItemEquipmentSlot;
import com.group1.web_games.repo.not_now.IGameItemEquipmentSlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameItemEquipmentSlotService implements IGameItemEquipmentSlotService {
    @Autowired
    private IGameItemEquipmentSlotRepo gameItemEquipmentSlotRepo;

    @Override
    public Iterable<GameItemEquipmentSlot> findAll() {
        return gameItemEquipmentSlotRepo.findAll();
    }

    @Override
    public Optional<GameItemEquipmentSlot> findById(Long id) {
        return gameItemEquipmentSlotRepo.findById(id);
    }

    @Override
    public GameItemEquipmentSlot save(GameItemEquipmentSlot gameItemEquipmentSlot) {
        return gameItemEquipmentSlotRepo.save(gameItemEquipmentSlot);
    }

    @Override
    public void remove(Long id) {
        gameItemEquipmentSlotRepo.deleteById(id);

    }
}
