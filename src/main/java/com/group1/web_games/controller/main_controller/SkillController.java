package com.group1.web_games.controller.main_controller;

import com.group1.web_games.model.main_entity.Skill;
import com.group1.web_games.model.main_entity.UserEntity;
import com.group1.web_games.service.skill.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private ISkillService skillService;
    @PostMapping
    private ResponseEntity<Skill> saveSkill(@RequestBody Skill skill){
        return new ResponseEntity<>(skillService.save(skill), HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<Iterable<Skill>>findAllSkill(){
        return new ResponseEntity<>(skillService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<Skill>deleteSkill(@PathVariable Long id){
        Optional<Skill> skill=skillService.findById(id);
        if(!skill.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        skillService.remove(id);
        return new ResponseEntity<>(skill.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<Skill>updateSkill(@PathVariable Long id){
        Optional<Skill>skill=skillService.findById(id);
        if(!skill.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        skillService.save(skill.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
