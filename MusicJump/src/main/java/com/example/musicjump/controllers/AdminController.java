package com.example.musicjump.controllers;


import com.example.musicjump.DTO.AddSkinDTO;
import com.example.musicjump.services.SkinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final SkinService skinService;

    @GetMapping
    public String getAdminPage(Model model){
        model.addAttribute("list", skinService.getAllSkins());
        model.addAttribute("skin", new AddSkinDTO());
        return "admin";
    }

    @PostMapping("/add_skin")
    public String addSkin(AddSkinDTO addSkinDTO){
        return skinService.addSkin(addSkinDTO);
    }
}
