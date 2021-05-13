package com.example.musicjump.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessDTO {
    private boolean success;
    private String message;
}
