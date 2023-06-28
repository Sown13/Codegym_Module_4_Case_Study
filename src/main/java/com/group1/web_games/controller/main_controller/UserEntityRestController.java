package com.group1.web_games.controller.main_controller;

import com.group1.web_games.model.main_entity.UserEntity;
import com.group1.web_games.model.user.User;
import com.group1.web_games.service.main_entity_service.user_entity.IUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
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

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity) {
        if (userEntityService.findByUserEmail(userEntity.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already exists");
        } else {
            userEntityService.save(userEntity);
            return ResponseEntity.ok().body("User register successfully");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserEntity userLogin) {
        Map<String, Object> hasMap = new HashMap<>();
        String text;

        UserEntity user = this.userEntityService.findByUserEmail(userLogin.getEmail());
        if (user != null) {
            if (userLogin.getAccountPassword().equals(userLogin.getAccountPassword())) {
                text = "Đăng nhập thành công";
                hasMap.put("text", text);
                hasMap.put("user1234567890", user);
                return new ResponseEntity<>(hasMap, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
