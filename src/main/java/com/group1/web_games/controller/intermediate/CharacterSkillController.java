package com.group1.web_games.controller.intermediate;

import com.group1.web_games.model.intermediate.CharacterItem;
import com.group1.web_games.model.intermediate.CharacterSkill;
import com.group1.web_games.repo.intermediate_repo.ICharacterSkillRepo;
import com.group1.web_games.service.character_skill.ICharacterSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/character-skill")
public class CharacterSkillController {
    @Autowired
    private ICharacterSkillService characterSkillService;
    @PostMapping
    private ResponseEntity<CharacterSkill> saveCharacterSkill(@RequestBody CharacterSkill characterSkill){
        return new ResponseEntity<>(characterSkillService.save(characterSkill), HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<Iterable<CharacterSkill>>findAllCharacterSkill(){
        return new ResponseEntity<>(characterSkillService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<CharacterSkill>deleteCharacterSkill(@PathVariable Long id){
        Optional<CharacterSkill> characterSkill=characterSkillService.findById(id);
        if(!characterSkill.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        characterSkillService.remove(id);
        return new ResponseEntity<>(characterSkill.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<CharacterSkill>updateCharacterSkill(@PathVariable Long id){
        Optional<CharacterSkill>characterSkill=characterSkillService.findById(id);
        if(!characterSkill.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        characterSkillService.save(characterSkill.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
