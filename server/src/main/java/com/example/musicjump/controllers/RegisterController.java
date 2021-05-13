package com.example.musicjump.controllers;
import com.example.musicjump.DTO.RegistrationDTO;
import com.example.musicjump.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reg")
@RequiredArgsConstructor
public class RegisterController {
    private final UserService userService;

    @GetMapping
    public String getRegPage(Model model){
        model.addAttribute("user", new RegistrationDTO());
        return "registration";
    }

    @PostMapping("/admin")
    public String addAdmin(RegistrationDTO registration){
        if(userService.addUser(registration, true).getBody().equals("Success")){
            return "redirect:/auth";
        }
        return "redirect:/reg";
    }
}
