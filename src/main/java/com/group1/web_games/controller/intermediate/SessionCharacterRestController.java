package com.group1.web_games.controller.intermediate;
import com.group1.web_games.model.intermediate.SessionCharacter;
import com.group1.web_games.service.intermediate_service.session_character.ISessionCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("session-character")
public class SessionCharacterRestController {
    @Autowired
    private ISessionCharacterService sessionCharacterService;
    @PostMapping
    private ResponseEntity<SessionCharacter> saveSessionCharacter(@RequestBody SessionCharacter sessionCharacter){
        return new ResponseEntity<>(sessionCharacterService.save(sessionCharacter), HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<Iterable<SessionCharacter>>findAllSessionCharacter(){
        return new ResponseEntity<>(sessionCharacterService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<SessionCharacter>deleteSessionCharacter(@PathVariable Long id){
        Optional<SessionCharacter> sessionCharacter=sessionCharacterService.findById(id);
        if(!sessionCharacter.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sessionCharacterService.remove(id);
        return new ResponseEntity<>(sessionCharacter.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<SessionCharacter>updateSessionCharacter(@PathVariable Long id){
        Optional<SessionCharacter>sessionCharacter=sessionCharacterService.findById(id);
        if(!sessionCharacter.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sessionCharacterService.save(sessionCharacter.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
