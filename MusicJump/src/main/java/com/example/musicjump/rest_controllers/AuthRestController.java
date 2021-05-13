package com.example.musicjump.rest_controllers;

import com.example.musicjump.DTO.SuccessDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
    @GetMapping("not_success_auth")
    public SuccessDTO notSuccess() {
        return new SuccessDTO(false, "User not found");
    }

    @GetMapping("success_auth")
    public SuccessDTO success() {
        return new SuccessDTO(true, "");
    }
}
