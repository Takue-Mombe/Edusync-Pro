package com.Hit200.Lecturer.s.Companion.Controllers;

import com.Hit200.Lecturer.s.Companion.Models.user;
import com.Hit200.Lecturer.s.Companion.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class UserController {

    @Autowired(required = true)
    private UserService userService;

    @PostMapping("/register")
    public user registerUser(@RequestBody user users) {
        user registeredUser = userService.registerUser(users);
        System.out.println("User registered successfully with username: " + registeredUser.getUsername());
        return registeredUser;
    }

    @PostMapping("/login") // Change to POST method for login
    public String loginUser(@RequestBody user user) { // Receive user credentials in request body
        // Here, implement your login logic using the provided username and password
        // For example, you can check the credentials against your database

        // If login is successful, return appropriate response
        return "Login successful!";
    }
}
