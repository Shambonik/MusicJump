package com.example.musicjump.services;

import com.example.musicjump.DTO.RegistrationDTO;
import com.example.musicjump.DTO.SuccessDTO;
import com.example.musicjump.models.Role;
import com.example.musicjump.models.Skin;
import com.example.musicjump.models.User;
import com.example.musicjump.repos.SkinRepo;
import com.example.musicjump.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final SkinRepo skinRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findUserByUsername(username);
    }

    public void addSkinToAllUsers(Skin skin){
        for(User user: userRepo.findAll()){
            user.getSkins().add(skin);
            userRepo.save(user);
        }
    }

    public void addOpenedSkinsToUser(User user){
        for(Skin skin: skinRepo.findAll()){
            if(skin.isOpenedForAllUsers()){
                user.getSkins().add(skin);
            }
        }
    }

    public SuccessDTO addUser(RegistrationDTO registration, boolean admin){
        User userFromDb = userRepo.findUserByUsername(registration.getUsername());
        if (userFromDb != null) {
            return new SuccessDTO(false, "User exists");
        }
        if(!registration.getPassword().equals(registration.getConfirm_password())){
            return new SuccessDTO(false, "Different passwords");
        }
        User user = new User();
        user.setUsername(registration.getUsername());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setActive(true);
        user.setSkins(new HashSet<Skin>());
        addOpenedSkinsToUser(user);
        if(admin){
            user.setRoles(Collections.singleton(Role.ADMIN));
        }
        else{
            user.setRoles(Collections.singleton(Role.USER));
        }
        userRepo.save(user);
        return new SuccessDTO(true, "");
    }
}
