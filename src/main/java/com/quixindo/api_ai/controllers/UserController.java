package com.quixindo.api_ai.controllers;

import com.quixindo.api_ai.dto.UserDTO;
import com.quixindo.api_ai.models.User;
import com.quixindo.api_ai.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String welcome(){
        return "Welcome!!! Find a best resource.";
    }

    @GetMapping("/users")
    public List<User> handleGetUsers() {
        return userService.listAll();
    }

    @PostMapping("/auth/register")
    public User handleRegister(@RequestBody UserDTO userDTO) throws Exception {
        return userService.register(userDTO);
    }

    @PostMapping("/auth/login")
    public String handleLogin() {
        return "Login Route";
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
