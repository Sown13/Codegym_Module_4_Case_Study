package com.group1.web_games.controller.main_controller;

import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.service.main_entity_service.game_character.IGameCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/game-character")
public class GameCharacterController {
    @Autowired
    private IGameCharacterService gameCharacterService;

    @GetMapping
    private ResponseEntity<Iterable<GameCharacter>> findAllGameCharacter() {
        return new ResponseEntity<>(gameCharacterService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{characterId}")
    private ResponseEntity<GameCharacter> findCharacterById(@PathVariable Long characterId) {
        return new ResponseEntity<>(gameCharacterService.findById(characterId).orElse(null), HttpStatus.OK);
    }
    @GetMapping("/player-list-alive/{gameSessionId}")
    private ResponseEntity<List<GameCharacter>> findAliveGameCharacterBySessionID(@PathVariable Long gameSessionId) {
        return new ResponseEntity<>(gameCharacterService.findListAlivePlayerBySessionId(gameSessionId), HttpStatus.OK);
    }
    @GetMapping("/player-list-dead/{gameSessionId}")
    private ResponseEntity<List<GameCharacter>> findDeadGameCharacterBySessionID(@PathVariable Long gameSessionId) {
        List<GameCharacter> deadGameCharacter = gameCharacterService.findListDeadEnemyBySessionId(gameSessionId);
        return new ResponseEntity<>(deadGameCharacter, HttpStatus.OK);
    }
    @GetMapping("/enemy-list-alive/{gameSessionId}")
    private ResponseEntity<List<GameCharacter>> findAliveEnemyBySessionID(@PathVariable Long gameSessionId) {
        return new ResponseEntity<>(gameCharacterService.findListAliveEnemyBySessionId(gameSessionId), HttpStatus.OK);
    }
    @GetMapping("/enemy-list-dead/{gameSessionId}")
    private ResponseEntity<List<GameCharacter>> findDeadEnemyBySessionID(@PathVariable Long gameSessionId) {
        return new ResponseEntity<>(gameCharacterService.findListDeadEnemyBySessionId(gameSessionId), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<GameCharacter> saveGameCharacter(@RequestBody GameCharacter gameCharacter) {
        return new ResponseEntity<>(gameCharacterService.save(gameCharacter), HttpStatus.OK);
    }

    @PostMapping("/test")
    private ResponseEntity<List<GameCharacter>> createPartyOf4() {
        return new ResponseEntity<>(gameCharacterService.createPartyOf4(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<GameCharacter> deleteGameCharacter(@PathVariable Long id) {
        Optional<GameCharacter> gameCharacter = gameCharacterService.findById(id);
        if (!gameCharacter.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gameCharacterService.remove(id);
        return new ResponseEntity<>(gameCharacter.get(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    private ResponseEntity<GameCharacter> updateGameCharacter(@PathVariable Long id) {
        Optional<GameCharacter> gameCharacter = gameCharacterService.findById(id);
        if (!gameCharacter.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gameCharacterService.save(gameCharacter.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
