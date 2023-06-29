package com.group1.web_games.controller.main_controller;

import com.group1.web_games.model.main_entity.CharacterDetail;
import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.service.main_entity_service.character_detail.ICharacterDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/character-detail")
public class CharacterDetailRestController {
    @Autowired
    private ICharacterDetailService characterDetailService;
    @GetMapping
    private ResponseEntity<Iterable<CharacterDetail>>findAllCharacterDetail(){
        return new ResponseEntity<>(characterDetailService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/game-character/{gameCharacterId}")
    private ResponseEntity<CharacterDetail>findGameCharacterDetailByCharacterId(@PathVariable Long gameCharacterId){
        return new ResponseEntity<>(characterDetailService.findCharacterDetailByGameCharacterId(gameCharacterId),HttpStatus.OK);
    }
    @GetMapping("/player-list-alive/{gameSessionId}")
    private ResponseEntity<List<CharacterDetail>> findAliveGameCharacterBySessionID(@PathVariable Long gameSessionId) {
        return new ResponseEntity<>(characterDetailService.findListAlivePlayerDetailBySessionId(gameSessionId), HttpStatus.OK);
    }
    @GetMapping("/player-list-dead/{gameSessionId}")
    private ResponseEntity<List<CharacterDetail>> findDeadGameCharacterBySessionID(@PathVariable Long gameSessionId) {
        return new ResponseEntity<>(characterDetailService.findListDeadPlayerDetailBySessionId(gameSessionId), HttpStatus.OK);
    }
    @GetMapping("/enemy-list-alive/{gameSessionId}")
    private ResponseEntity<List<CharacterDetail>> findAliveEnemyBySessionID(@PathVariable Long gameSessionId) {
        return new ResponseEntity<>(characterDetailService.findListAliveEnemyDetailBySessionId(gameSessionId), HttpStatus.OK);
    }
    @GetMapping("/enemy-list-dead/{gameSessionId}")
    private ResponseEntity<List<CharacterDetail>> findDeadEnemyBySessionID(@PathVariable Long gameSessionId) {
        return new ResponseEntity<>(characterDetailService.findListDeadEnemyDetailBySessionId(gameSessionId), HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<CharacterDetail>saveCharacterDetail(@RequestBody CharacterDetail characterDetail){
        return new ResponseEntity<>(characterDetailService.save(characterDetail), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<CharacterDetail>deleteCharacterDetailById(@PathVariable Long id){
        Optional<CharacterDetail>characterDetail=characterDetailService.findById(id);
        if(!characterDetail.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        characterDetailService.remove(id);
        return new ResponseEntity<>(characterDetail.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<CharacterDetail>updateCharacterDetail(@PathVariable Long id){
        Optional<CharacterDetail>characterDetail=characterDetailService.findById(id);
        if(!characterDetail.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        characterDetailService.save(characterDetail.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}