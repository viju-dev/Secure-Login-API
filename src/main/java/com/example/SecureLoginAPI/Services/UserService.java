package com.example.SecureLoginAPI.Services;

import com.example.SecureLoginAPI.Convertors.UserConvertor;
import com.example.SecureLoginAPI.Dtos.UserResponseDto;
import com.example.SecureLoginAPI.Models.User;
import com.example.SecureLoginAPI.Repositories.UserRepo;
import com.example.SecureLoginAPI.Validators.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create a new user
    public UserResponseDto createUser(User user) {
        try {
            user.setId(UUID.randomUUID().toString());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            if (EmailValidator.isValidEmail(user.getEmail())){
                userRepo.save(user);
            }
            else {

            }

            return UserConvertor.EntityToDto(user);
        } catch (Exception e) {
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }
    }

    // Get all users
    public List<UserResponseDto> getUsers(){
        List<UserResponseDto> list = new ArrayList<>();
        //converted all users to responseDtos to hide sensitive information and show what is required
        for (User u:userRepo.findAll()) {
            list.add(UserConvertor.EntityToDto(u));
        }
        return list;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
