package com.example.musicjump.rest_controllers;

import com.example.musicjump.models.Skin;
import com.example.musicjump.services.SkinService;
import com.example.musicjump.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/skins")
@RequiredArgsConstructor
public class SkinsController {
    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<Set<Skin>> getListOfSkins(@PathVariable("username") String username){
        return userService.getListOfSkins(username);
    }

}
