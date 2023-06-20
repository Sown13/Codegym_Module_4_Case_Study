package com.group1.web_games.controller.main_controller;

import com.group1.web_games.model.intermediate.CharacterItem;

import com.group1.web_games.service.character_item.ICharacterItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/character-item")
public class CharacterItemController {
    @Autowired
    private ICharacterItemService characterItemService;
    @PostMapping
    private ResponseEntity<CharacterItem> saveCharacterItem(@RequestBody CharacterItem characterItem){
        return new ResponseEntity<>(characterItemService.save(characterItem), HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<Iterable<CharacterItem>>findAllCharacterItem(){
        return new ResponseEntity<>(characterItemService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<CharacterItem>deleteCharacterItem(@PathVariable Long id){
        Optional<CharacterItem> characterItem=characterItemService.findById(id);
        if(!characterItem.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        characterItemService.remove(id);
        return new ResponseEntity<>(characterItem.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<CharacterItem>updateCharacterItem(@PathVariable Long id){
        Optional<CharacterItem>characterItem=characterItemService.findById(id);
        if(!characterItem.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        characterItemService.save(characterItem.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
