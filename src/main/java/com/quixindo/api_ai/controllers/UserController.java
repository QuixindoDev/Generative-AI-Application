package com.quixindo.api_ai.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/")
    public String handleGetUsers() {
        return "List all users";
    }

    @PostMapping("/")
    public String handleRegister(){
        return "Register method";
    }

    @PutMapping("/upd/${id}")
    public String handleUpdateUsers(){
        return "Update method";
    }

    @DeleteMapping("users/del/${id}")
    public String handleDeleteUsers()
    {
        return "Delete method";
    }
}
