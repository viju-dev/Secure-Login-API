package com.example.SecureLoginAPI.Services;

import com.example.SecureLoginAPI.Models.User;
import com.example.SecureLoginAPI.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    // Load user details by username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            // User retrieval logic
            User user = userRepo.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return user;
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Error retrieving user: " + e.getMessage());
        }
    }
}
