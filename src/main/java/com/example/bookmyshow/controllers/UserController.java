package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.dtos.SignUpRequestDTO;
import com.example.bookmyshow.dtos.SignUpResponseDTO;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO){
        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();

        try{
            User user = userService.signUp(signUpRequestDTO.getName(),
                    signUpRequestDTO.getEmail(),
                    signUpRequestDTO.getPassword());

            signUpResponseDTO.setUser(user);
            signUpResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(Exception e){
            signUpResponseDTO.setResponseStatus(ResponseStatus.FAILED);
        }
        return signUpResponseDTO;
    }
}
