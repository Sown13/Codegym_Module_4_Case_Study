package com.group1.web_games.controller.user;

import com.group1.web_games.model.user.User;
import com.group1.web_games.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService iUserService;


    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        List<User> users = (List<User>) iUserService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserInformation(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOptional = iUserService.findById(id);
        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(userOptional.get().getId());
        return new ResponseEntity<>(iUserService.save(user), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return new ResponseEntity<>(iUserService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (iUserService.findByUserEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already exists");
        } else {
            iUserService.save(user);
            return ResponseEntity.ok().body("User register successfully");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User userLogin) {
        Map<String, Object> hasMap = new HashMap<>();
        String text;

        User user = this.iUserService.findByUserEmail(userLogin.getEmail());
        if (user != null) {
            if (user.getPassword().equals(userLogin.getPassword())) {
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


