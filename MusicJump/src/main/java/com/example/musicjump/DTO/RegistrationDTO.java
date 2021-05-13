package com.example.musicjump.DTO;

import lombok.Data;

@Data
public class RegistrationDTO {
    private String username;
    private String password;
    private String confirm_password;
}
