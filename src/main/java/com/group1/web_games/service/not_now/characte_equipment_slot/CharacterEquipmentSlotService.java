package com.group1.web_games.service.not_now.characte_equipment_slot;

import com.group1.web_games.model.not_now.CharacterEquipmentSlot;
import com.group1.web_games.repo.not_now.ICharacterEquipmentSlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CharacterEquipmentSlotService implements ICharacterEquipmentSlotService {
    @Autowired
    private ICharacterEquipmentSlotRepo characterEquipmentSlotRepo;
    @Override
    public Iterable<CharacterEquipmentSlot> findAll() {
       return characterEquipmentSlotRepo.findAll();
    }

    @Override
    public Optional<CharacterEquipmentSlot> findById(Long id) {
        return characterEquipmentSlotRepo.findById(id);
    }

    @Override
    public CharacterEquipmentSlot save(CharacterEquipmentSlot characterEquipmentSlot) {
        return characterEquipmentSlotRepo.save(characterEquipmentSlot);
    }

    @Override
    public void remove(Long id) {
        characterEquipmentSlotRepo.deleteById(id);
    }
}
