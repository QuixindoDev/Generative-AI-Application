package com.quixindo.api_ai.services;

import com.quixindo.api_ai.dto.UserDTO;
import com.quixindo.api_ai.models.User;
import com.quixindo.api_ai.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User register(UserDTO userDTO) throws Exception {
        Optional<User> email = userRepository.findByEmail(userDTO.email());
        if (email.isPresent())
            throw new Exception("This email cannot be registered");
        User user = new User();
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPassword(passwordEncoder.encode(userDTO.password()));
        return userRepository.save(user);
    }


}
