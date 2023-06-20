package com.group1.web_games.controller;

import com.group1.web_games.model.main_entity.EquipmentSlot;
import com.group1.web_games.service.equipment_slot.IEquipmentSlotSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/equipment-slot")
public class EquipmentSlotController {
    @Qualifier("equipmentSlotService")
    @Autowired
    private IEquipmentSlotSer equipmentSlotSer;
    @PostMapping
    private ResponseEntity<EquipmentSlot>saveEquipmentSlot(@RequestBody EquipmentSlot equipmentSlot){
        return new ResponseEntity<>(equipmentSlotSer.save(equipmentSlot), HttpStatus.OK);
    }
    @GetMapping ResponseEntity<Iterable<EquipmentSlot>>findAllEquipmentSlot(){
        return new ResponseEntity<>(equipmentSlotSer.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<EquipmentSlot>deleteEquipmentSlot(@PathVariable Long id){
        Optional<EquipmentSlot>equipmentSlot=equipmentSlotSer.findById(id);
        if(!equipmentSlot.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        equipmentSlotSer.remove(id);
        return new ResponseEntity<>(equipmentSlot.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<EquipmentSlot>updateEquipmentSlot(@PathVariable Long id){
        Optional<EquipmentSlot>equipmentSlot=equipmentSlotSer.findById(id);
        if(!equipmentSlot.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        equipmentSlotSer.save(equipmentSlot.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
