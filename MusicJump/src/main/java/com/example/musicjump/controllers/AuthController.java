package com.example.musicjump.controllers;

import com.example.musicjump.DTO.SuccessDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping
    public String getAuthPage(){
        return "auth";
    }
}

