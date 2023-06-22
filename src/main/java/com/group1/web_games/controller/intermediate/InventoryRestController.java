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
    private IInventoryService iInventoryService;
    @PostMapping
    private ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory){
        return new ResponseEntity<>(iInventoryService.save(inventory), HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<Iterable<Inventory>>findAllInventory(){
        return new ResponseEntity<>(iInventoryService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<Inventory>deleteInventory(@PathVariable Long id){
        Optional<Inventory> inventory=iInventoryService.findById(id);
        if(!inventory.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iInventoryService.remove(id);
        return new ResponseEntity<>(inventory.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<Inventory>updateInventory(@PathVariable Long id){
        Optional<Inventory>inventory=iInventoryService.findById(id);
        if(!inventory.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iInventoryService.save(inventory.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
