package com.example.musicjump.rest_controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    @GetMapping("not_success_auth")
    public ResponseEntity<String> notSuccess() {
        return new ResponseEntity<>("User not found", HttpStatus.OK);
    }

    @GetMapping("success_auth")
    public ResponseEntity<String> success() {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
