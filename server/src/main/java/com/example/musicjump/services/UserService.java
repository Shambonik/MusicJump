package com.example.musicjump.services;

import com.example.musicjump.DTO.RegistrationDTO;
import com.example.musicjump.models.Role;
import com.example.musicjump.models.Skin;
import com.example.musicjump.models.User;
import com.example.musicjump.repos.SkinRepo;
import com.example.musicjump.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public ResponseEntity<Set<Skin>> getListOfSkins(String username){
        return new ResponseEntity<>(userRepo.findUserByUsername(username).getSkins(), HttpStatus.OK);
    }

    public ResponseEntity<String> addUser(RegistrationDTO registration, boolean admin){
        if((registration.getPassword() == null || registration.getConfirm_password() == null || registration.getUsername() == null)
            ||(registration.getPassword().equals("") || registration.getConfirm_password().equals("")
            || registration.getUsername().equals(""))){
            return new ResponseEntity<>("Null field", HttpStatus.OK);
        }
        User userFromDb = userRepo.findUserByUsername(registration.getUsername());
        if (userFromDb != null) {
            return new ResponseEntity<>("User exists", HttpStatus.OK);
        }
        if(!registration.getPassword().equals(registration.getConfirm_password())){
            return new ResponseEntity<>("Different passwords", HttpStatus.OK);
        }
        User user = new User();
        user.setUsername(registration.getUsername());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setActive(true);
        user.setSkins(new HashSet<>());
        addOpenedSkinsToUser(user);
        if(admin){
            user.setRoles(Collections.singleton(Role.ADMIN));
        }
        else{
            user.setRoles(Collections.singleton(Role.USER));
        }
        userRepo.save(user);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
