package com.group1.web_games.controller.main_controller;

import com.group1.web_games.model.intermediate.CharacterEquipmentSlot;
import com.group1.web_games.service.characte_equipment_slot.ICharacterEquipmentSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @GetMapping
    private ResponseEntity<Iterable<CharacterEquipmentSlot>>findAllCharacterEquipmentSlot(){
        return new ResponseEntity<>(characterEquipmentSlotService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<CharacterEquipmentSlot>removeCharacterEquipmentSlot(@PathVariable Long id){
        Optional<CharacterEquipmentSlot>characterEquipmentSlot=characterEquipmentSlotService.findById(id);
        if(!characterEquipmentSlot.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        characterEquipmentSlotService.remove(id);
        return new ResponseEntity<>(characterEquipmentSlot.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<CharacterEquipmentSlot>updateCharacterEquipmentSlot(@PathVariable Long id){

        Optional<CharacterEquipmentSlot> characterEquipmentSlot=characterEquipmentSlotService.findById(id);
        if(!characterEquipmentSlot.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
               characterEquipmentSlotService.save(characterEquipmentSlot.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
