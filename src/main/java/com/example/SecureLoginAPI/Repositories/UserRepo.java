package com.example.SecureLoginAPI.Repositories;

import com.example.SecureLoginAPI.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    public Optional<User> findByEmail(String email);
}
