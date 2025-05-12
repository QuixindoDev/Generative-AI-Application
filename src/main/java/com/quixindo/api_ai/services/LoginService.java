package com.quixindo.api_ai.services;

import com.quixindo.api_ai.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
