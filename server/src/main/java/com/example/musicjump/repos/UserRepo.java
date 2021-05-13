package com.example.musicjump.repos;

import com.example.musicjump.models.Skin;
import com.example.musicjump.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByUsername(String name);
}
