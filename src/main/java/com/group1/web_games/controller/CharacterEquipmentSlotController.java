package com.group1.web_games.model;

import com.group1.web_games.model.intermediate.CharacterEquipmentSlot;
import com.group1.web_games.service.characte_equipment_slot.ICharacterEquipmentSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/character-equipment-slot")
public class CharacterEquipmentSlotController {
    @Autowired
    private ICharacterEquipmentSlotService characterEquipmentSlotService;
    @PostMapping
    private ResponseEntity<CharacterEquipmentSlot>saveCharacterEquipmentSlot(@RequestBody CharacterEquipmentSlot characterEquipmentSlot){
     return new ResponseEntity<>(characterEquipmentSlotService.save(characterEquipmentSlot), HttpStatus.OK);
    }
}
