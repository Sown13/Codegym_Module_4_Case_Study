package com.group1.web_games.controller.intermediate;
import com.group1.web_games.model.intermediate.Inventory;
import com.group1.web_games.service.intermediate_service.inventory.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/inventory")
public class InventoryRestController {
    @Autowired
    private IInventoryService inventoryService;
    @GetMapping
    private ResponseEntity<Iterable<Inventory>>findAllInventory(){
        return new ResponseEntity<>(inventoryService.findAll(),HttpStatus.OK);
    }
    @GetMapping("game-session/{gameSessionId}")
    private ResponseEntity<Iterable<Inventory>>findAllInventoryByGameSessionId(@PathVariable Long gameSessionId){
        return new ResponseEntity<>(inventoryService.findInventoryByGameSessionId(gameSessionId),HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory){
        return new ResponseEntity<>(inventoryService.save(inventory), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Inventory>deleteInventory(@PathVariable Long id){
        Optional<Inventory> inventory= inventoryService.findById(id);
        if(!inventory.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        inventoryService.remove(id);
        return new ResponseEntity<>(inventory.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<Inventory>updateInventory(@PathVariable Long id){
        Optional<Inventory>inventory= inventoryService.findById(id);
        if(!inventory.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        inventoryService.save(inventory.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
