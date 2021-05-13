package com.example.musicjump.repos;

import com.example.musicjump.models.Skin;
import com.example.musicjump.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkinRepo extends JpaRepository<Skin, Long> {
    Skin findUserByName(String name);
}
