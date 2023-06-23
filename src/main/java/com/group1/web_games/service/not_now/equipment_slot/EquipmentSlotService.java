package com.group1.web_games.service.not_now.equipment_slot;

import com.group1.web_games.model.not_now.EquipmentSlot;
import com.group1.web_games.repo.not_now.IEquipmentSlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EquipmentSlotService implements IEquipmentSlotSer {
    @Autowired
    private IEquipmentSlotRepo equipmentSlotRepo;
    @Override
    public Iterable<EquipmentSlot> findAll() {
     return    equipmentSlotRepo.findAll();
    }

    @Override
    public Optional<EquipmentSlot> findById(Long id) {
        return equipmentSlotRepo.findById(id);
    }

    @Override
    public EquipmentSlot save(EquipmentSlot equipmentSlot) {
        return equipmentSlotRepo.save(equipmentSlot);
    }

    @Override
    public void remove(Long id) {
        equipmentSlotRepo.deleteById(id);
    }
}
