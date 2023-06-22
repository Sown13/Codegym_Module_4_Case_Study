package com.group1.web_games.controller.intermediate;
import com.group1.web_games.model.intermediate.GameItemEquipmentSlot;
import com.group1.web_games.service.intermediate_service.game_item_equipment_slot.IGameItemEquipmentSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/game-item-equipment-slot")
public class GameItemEquipmentSlotRestController {
    @Autowired
    private IGameItemEquipmentSlotService gameItemEquipmentSlotService;
    @PostMapping
    private ResponseEntity<GameItemEquipmentSlot> saveGameItemEquipmentSlot(@RequestBody GameItemEquipmentSlot gameItemEquipmentSlot){
        return new ResponseEntity<>(gameItemEquipmentSlotService.save(gameItemEquipmentSlot), HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<Iterable<GameItemEquipmentSlot>>findAllGameItemEquipmentSlot(){
        return new ResponseEntity<>(gameItemEquipmentSlotService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<GameItemEquipmentSlot>deleteGameItemEquipmentSlot(@PathVariable Long id){
        Optional<GameItemEquipmentSlot> gameItemEquipmentSlot=gameItemEquipmentSlotService.findById(id);
        if(!gameItemEquipmentSlot.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gameItemEquipmentSlotService.remove(id);
        return new ResponseEntity<>(gameItemEquipmentSlot.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<GameItemEquipmentSlot>updateGameItemEquipmentSlot(@PathVariable Long id){
        Optional<GameItemEquipmentSlot>gameItemEquipmentSlot=gameItemEquipmentSlotService.findById(id);
        if(!gameItemEquipmentSlot.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gameItemEquipmentSlotService.save(gameItemEquipmentSlot.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
