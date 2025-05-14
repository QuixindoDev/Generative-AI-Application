package com.quixindo.api_ai.controllers;

import com.quixindo.api_ai.dto.UserDTO;
import com.quixindo.api_ai.models.User;
import com.quixindo.api_ai.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok().body("Welcome!!! Find a best resource.");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> handleGetUsers() {
        List<User> users = userService.listAll();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<User> handleRegister(@RequestBody UserDTO userDTO) throws Exception {
        User user = userService.register(userDTO);
        return ResponseEntity.status(201).body(user);
    }

//    @PutMapping("/upd/${id}")
//    public String handleUpdateUsers(){
//        return "Update method";
//    }
//
//    @DeleteMapping("users/del/${id}")
//    public String handleDeleteUsers()
//    {
//        return "Delete method";
//    }
}
