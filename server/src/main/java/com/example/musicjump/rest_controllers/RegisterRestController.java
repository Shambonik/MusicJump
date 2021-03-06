package com.example.musicjump.rest_controllers;

import com.example.musicjump.DTO.RegistrationDTO;
import com.example.musicjump.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
@RequiredArgsConstructor
public class RegisterRestController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody RegistrationDTO registration){
        return userService.addUser(registration, false);
    }
}
