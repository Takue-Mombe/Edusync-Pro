package com.Hit200.Lecturer.s.Companion.Controllers;

import com.Hit200.Lecturer.s.Companion.Models.user;
import com.Hit200.Lecturer.s.Companion.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired(required = true)
    private UserService userService;

    @PostMapping("/register")
    public user registerUser(@RequestBody user users) {
        user registeredUser = userService.registerUser(users);
        System.out.println("User registered successfully with username: " + registeredUser.getUsername());
        return registeredUser;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody user credentials) {
        // Replace UserCredentials with your actual request body model
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // Basic authentication check (replace with your actual authentication logic)
        System.out.println(username.concat(password));
        if ("admin".equals(username) && "password".equals(password)) {
            // Successful login
            return ResponseEntity.ok().body("{\"message\": \"Login successful\"}");
        } else {
            // Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Unauthorized\"}");
        }
    }

}
