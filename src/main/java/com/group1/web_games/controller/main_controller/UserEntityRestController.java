package com.group1.web_games.controller.main_controller;

import com.group1.web_games.model.main_entity.UserEntity;
import com.group1.web_games.service.user_entity.IUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user-entity")
public class UserEntityRestController {
    @Autowired
    private IUserEntityService userEntityService;
    @PostMapping
    private ResponseEntity<UserEntity> saveUserEntity(@RequestBody UserEntity userEntity){
        return new ResponseEntity<>(userEntityService.save(userEntity), HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<Iterable<UserEntity>>findAllUserEntity(){
        return new ResponseEntity<>(userEntityService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<UserEntity>deleteUserEntity(@PathVariable Long id){
        Optional<UserEntity> userEntity=userEntityService.findById(id);
        if(!userEntity.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userEntityService.remove(id);
        return new ResponseEntity<>(userEntity.get(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<UserEntity>updateUserEntity(@PathVariable Long id){
        Optional<UserEntity>userEntity=userEntityService.findById(id);
        if(!userEntity.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userEntityService.save(userEntity.orElse(null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
