package com.example.musicjump.repos;

import com.example.musicjump.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByUsername(String name);
}
