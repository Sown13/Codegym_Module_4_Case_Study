package com.group1.web_games.controller.main_controller;


import com.group1.web_games.model.main_entity.GameItem;
import com.group1.web_games.service.main_entity_service.game_item.IGameItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/game-item")
public class GameItemRestController {

    @Autowired
    private IGameItemService gameItemService;
    @GetMapping
    private ResponseEntity<Iterable<GameItem>>findAllGameItem(){
        return new ResponseEntity<>(gameItemService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/game-session/{gameSessionId}")
    private ResponseEntity<Iterable<GameItem>>findGameItemBySession(@PathVariable Long gameSessionId){
        return new ResponseEntity<>(gameItemService.getItemListByGameSession(gameSessionId),HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<GameItem> saveGameItem(@RequestBody GameItem gameItem){
        return new ResponseEntity<>(gameItemService.save(gameItem), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<GameItem>deleteGameItem(@PathVariable Long id){
        Optional<GameItem> gameItem=gameItemService.findById(id);
        if(!gameItem.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gameItemService.remove(id);
        return new ResponseEntity<>(gameItem.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<GameItem>updateGameItem(@PathVariable Long id){
        Optional<GameItem>gameItem=gameItemService.findById(id);
        if(!gameItem.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gameItemService.save(gameItem.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
