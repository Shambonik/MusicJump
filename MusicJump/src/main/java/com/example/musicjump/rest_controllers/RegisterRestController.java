package com.example.musicjump.rest_controllers;

import com.example.musicjump.DTO.RegistrationDTO;
import com.example.musicjump.DTO.SuccessDTO;
import com.example.musicjump.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reg")
@RequiredArgsConstructor
public class RegisterRestController {
    private final UserService userService;

    @PostMapping
    public SuccessDTO registerUser(RegistrationDTO registration){
        return userService.addUser(registration, false);
    }
}
