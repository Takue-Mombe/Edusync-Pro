package com.Hit200.Lecturer.s.Companion.Controllers;

import com.Hit200.Lecturer.s.Companion.Models.user;
import com.Hit200.Lecturer.s.Companion.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired(required = true)
    private UserService userService;

    @PostMapping("/register")
    public user registerUser(@RequestBody user users) {
        user registeredUser = userService.registerUser(users);
        System.out.println("User registered successfully with username: " + registeredUser.getUsername());
        return registeredUser;
    }

    @GetMapping("/login")
    public String loginUser() {
        return "Login successful!";
    }
}
