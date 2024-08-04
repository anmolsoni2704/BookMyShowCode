package com.example.bookmyshow.services;

import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signUp(String name, String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        User savedUser = null;

        if(optionalUser.isPresent()){
            savedUser = optionalUser.get();
        } else{
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            userRepository.save(user);
        }
        return savedUser;
    }
}
