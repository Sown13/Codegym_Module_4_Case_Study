package com.group1.web_games.controller.main_controller;

import com.group1.web_games.model.main_entity.CharacterDetail;
import com.group1.web_games.service.character_detail.ICharacterDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/character-detail-controller")
public class CharacterDetailRestController {
    @Autowired
    private ICharacterDetailService characterDetailService;
    @PostMapping
    private ResponseEntity<CharacterDetail>saveCharacterDetail(@RequestBody CharacterDetail characterDetail){
        return new ResponseEntity<>(characterDetailService.save(characterDetail), HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<Iterable<CharacterDetail>>findAllCharacterDetail(){
        return new ResponseEntity<>(characterDetailService.findAll(),HttpStatus.OK);
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