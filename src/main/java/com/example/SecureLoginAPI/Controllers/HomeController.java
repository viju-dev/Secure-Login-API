package com.example.SecureLoginAPI.Controllers;

import com.example.SecureLoginAPI.Dtos.UserResponseDto;
import com.example.SecureLoginAPI.Models.User;
import com.example.SecureLoginAPI.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    // Endpoint to retrieve a list of all users
    @GetMapping("/getUsers")
    public ResponseEntity getUsers() {
        try {
            // Invoke the userService to get all users
            List<UserResponseDto> users = userService.getUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exception
            return new ResponseEntity<>("Error retrieving users: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to retrieve the currently logged-in user
    @GetMapping("/currentUser")
    public ResponseEntity getLoggedInUser(Principal principal) {
        try {
            String username = principal.getName();
            return new ResponseEntity<>(username, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving logged-in user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
