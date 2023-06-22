package com.group1.web_games.controller.main_controller;
import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.service.main_entity_service.game_character.IGameCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/game-character")
public class GameCharacterController {
    @Autowired
    private IGameCharacterService gameCharacterService;
    @PostMapping
    private ResponseEntity<GameCharacter>saveGameCharacter(@RequestBody GameCharacter gameCharacter){
        return new ResponseEntity<>(gameCharacterService.save(gameCharacter), HttpStatus.OK);
    }
    @PostMapping("/test")
    private ResponseEntity<List<GameCharacter>>createPartyOf4(){
        return new ResponseEntity<>(gameCharacterService.createPartyOf4(),HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<Iterable<GameCharacter>>findAllGameCharacter(){
        return new ResponseEntity<>(gameCharacterService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<GameCharacter>deleteGameCharacter(@PathVariable Long id){
        Optional<GameCharacter>gameCharacter=gameCharacterService.findById(id);
        if(!gameCharacter.isPresent()){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gameCharacterService.remove(id);
        return new ResponseEntity<>(gameCharacter.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<GameCharacter>updateGameCharacter(@PathVariable Long id){
        Optional<GameCharacter>gameCharacter=gameCharacterService.findById(id);
        if(!gameCharacter.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gameCharacterService.save(gameCharacter.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
